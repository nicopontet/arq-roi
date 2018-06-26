
package com.kremlin.impl;

import com.kremlin.imp.dto.QueueDTO;
import com.kremlin.imp.entity.ServiceOperation;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.kremlin.persistence.ServicePersistenceLocal;
import com.kremlin.typecommunication.impl.JMSImplementation;
import com.kremlin.typecommunication.impl.RESTImplementation;
import com.kremlin.typecommunication.impl.TypeCommunicationEnum;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;

@Stateless
public class ServiceBean implements ServiceBeanLocal {

    /*@EJB
    private PlannerBeanRemote plannerBean;*/

    @EJB
    private ServicePersistenceLocal servicePersistenceLocal;
    
    public ServiceBean(){}
    
   
    @Override
    public void registerService(ServiceOperation operation) throws InvalidNameServiceOperationException {
       boolean existService= existServiceOperationName(operation.getName());
       
       if (!existService){
           servicePersistenceLocal.create(operation);
       }else{
           throw new InvalidNameServiceOperationException();
       }
    }

    @Override
    public List<ServiceOperation> getServices() {
        List<ServiceOperation> services;
        services=servicePersistenceLocal.findAll();
        return services;
    }
    private boolean existServiceOperationName(String name){
        ServiceOperation service=servicePersistenceLocal.findServiceOperationByName(name);
        return service!=null;
    }
    @Override
    public ServiceOperation getServiceOperationByName(String name){
        return servicePersistenceLocal.findServiceOperationByName(name);  
    }
    
    @Override
    public Response sendData(String serviceOperationName,String token,String jsonBody) throws CallServiceOperationException{
       ServiceOperation service = servicePersistenceLocal.findServiceOperationByName(serviceOperationName);
       Response response = null;
       if (service!=null){ 
        TypeCommunicationEnum typeCom = service.getTypeCommunication();
        switch (typeCom){
            case REST:
                String operationUrl = service.getResources();
                String method = service.getAdditionalData();
                response = RESTImplementation.callOperation(service,jsonBody);
                break;
            case JMS:
                QueueDTO sendQueueDTO = new QueueDTO(token,jsonBody,serviceOperationName);
                String data = sendQueueDTO.toJson();
                String connectionFactory=service.getResources();
                String queue= service.getAdditionalData();
                JMSImplementation jmsImp = new JMSImplementation(connectionFactory,queue);
                jmsImp.sendMessage(data);
                break;
            case REMOTE:
                //plannerBean.getClass().getMethods();
                /*java.lang.reflect.Method method;
                try {
                    method = plannerBean.getClass().getMethod("CreatePlan");
                    Object[] args = null;
                    method.invoke(plannerBean,args);
                } catch (SecurityException e) { }
                  catch (NoSuchMethodException e) { } 
                  catch (IllegalAccessException ex) {} 
                  catch (IllegalArgumentException ex) {} 
                  catch (InvocationTargetException ex) {}*/
                break;
            default:
                break;
        }
       }else{
           throw new CallServiceOperationException("Not found serivice operation");
       }
       return response;
    }


}
