
package com.roisupplying.order.imp;

import com.google.gson.Gson;
import com.roisupplying.dto.ServiceOperationDTO;
import com.roisupplying.dto.ServiceOperationParamDTO;
import com.roisupplying.dto.TypeDataDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Startup
@LocalBean
public class RegistrationBean {
    
    public static final String OPERATION_CREATE_ORDER = "CreateOrder";
    public static final String OPERATION_MODIFY_ORDER = "ModifyOrder";
    public static final String OPERATION_DELETE_ORDER = "DeleteOrder";
    private Gson gson;
    
    @PostConstruct
    private void init() {
        gson = new Gson();
        registerCreateOrder();
        registerModifyOrder();
        registerDeleteOrder();
    }
    
    private void registerOperation(ServiceOperationDTO serviceOperation){
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/kremlin-war/services")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(gson.toJson(serviceOperation)));
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            
        }
    }
    
    public void registerCreateOrder(){
        ServiceOperationDTO serviceOperation = new ServiceOperationDTO();
        serviceOperation.setName(OPERATION_CREATE_ORDER);
        serviceOperation.setTypeReturn("void");
        serviceOperation.setTypeCommunication("JMS");
        serviceOperation.setResources("jms/RoiSupplyingConnectionFactory");
        serviceOperation.setAdditionalData("jms/RoiSupplyingQueue");
        List<ServiceOperationParamDTO> parameters = new ArrayList<ServiceOperationParamDTO>();
        parameters.add(new ServiceOperationParamDTO("orderAction", "String", 1));
        //int clientId;
        parameters.add(new ServiceOperationParamDTO("clientId", "int", 2));
        //Date startDate;
        parameters.add(new ServiceOperationParamDTO("startDate", "Date", 3));
        //int hiredVolume;
        parameters.add(new ServiceOperationParamDTO("hiredVolume", "int", 4));
        //int serviceStationNumber;
        parameters.add(new ServiceOperationParamDTO("serviceStationNumber", "int", 5));
        //int closingBillingDate;
        parameters.add(new ServiceOperationParamDTO("closingBillingDate", "int", 6));
        serviceOperation.setServiceParams(parameters);
        serviceOperation.setTypesData(new ArrayList<TypeDataDTO>());
        registerOperation(serviceOperation);
    }
    
    public void registerModifyOrder(){
        ServiceOperationDTO serviceOperation = new ServiceOperationDTO();
        serviceOperation.setName(OPERATION_MODIFY_ORDER);
        serviceOperation.setTypeReturn("void");
        serviceOperation.setTypeCommunication("JMS");
        serviceOperation.setResources("jms/RoiSupplyingConnectionFactory");
        serviceOperation.setAdditionalData("jms/RoiSupplyingQueue");
        List<ServiceOperationParamDTO> parameters = new ArrayList<ServiceOperationParamDTO>();
        parameters.add(new ServiceOperationParamDTO("orderAction", "String", 1));
        //int orderId
        parameters.add(new ServiceOperationParamDTO("orderId", "int", 1));
        //int clientId;
        parameters.add(new ServiceOperationParamDTO("clientId", "int", 2));
        //Date startDate;
        parameters.add(new ServiceOperationParamDTO("startDate", "Date", 3));
        //int hiredVolume;
        parameters.add(new ServiceOperationParamDTO("hiredVolume", "int", 4));
        //int serviceStationNumber;
        parameters.add(new ServiceOperationParamDTO("serviceStationNumber", "int", 5));
        //int closingBillingDate;
        parameters.add(new ServiceOperationParamDTO("closingBillingDate", "int", 6));
        serviceOperation.setServiceParams(parameters);
        serviceOperation.setTypesData(new ArrayList<TypeDataDTO>());
        registerOperation(serviceOperation);
    }
    
    public void registerDeleteOrder(){
        ServiceOperationDTO serviceOperation = new ServiceOperationDTO();
        serviceOperation.setName(OPERATION_DELETE_ORDER);
        serviceOperation.setTypeReturn("void");
        serviceOperation.setTypeCommunication("JMS");
        serviceOperation.setResources("jms/RoiSupplyingConnectionFactory");
        serviceOperation.setAdditionalData("jms/RoiSupplyingQueue");
        List<ServiceOperationParamDTO> parameters = new ArrayList<ServiceOperationParamDTO>();
        parameters.add(new ServiceOperationParamDTO("orderAction", "String", 1));
        //int orderId
        parameters.add(new ServiceOperationParamDTO("orderId", "int", 1));
        serviceOperation.setServiceParams(parameters);
        serviceOperation.setTypesData(new ArrayList<TypeDataDTO>());
        registerOperation(serviceOperation);
    }
}
