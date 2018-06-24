/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.impl;

import com.kremlin.imp.entity.ServiceOperation;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.kremlin.persistence.ServicePersistenceLocal;
import com.kremlin.typecommunication.impl.JMSImplementation;
import com.kremlin.typecommunication.impl.TypeCommunicationEnum;
import java.util.List;

/**
 *
 * @author NICO_CUARTO
 */
@Stateless
public class ServiceBean implements ServiceBeanLocal {

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
    public void sendData(String serviceOperationName,  String data) throws CallServiceOperationException{
       ServiceOperation service=servicePersistenceLocal.findServiceOperationByName(serviceOperationName);
       if (service!=null){ 
        TypeCommunicationEnum typeCom=service.getTypeCommunication();
        switch (typeCom){
            case REST:
            case JMS:
                  String connectionFactory=service.getResources();
                  String queue= service.getAdditionalData();
                  JMSImplementation jmsImp = new JMSImplementation(connectionFactory,queue);
                  jmsImp.sendMessage(data);
            case REMOTE:
            default:
        }
       }else{
           throw new CallServiceOperationException("Not found serivice operation");
       }
    }


}
