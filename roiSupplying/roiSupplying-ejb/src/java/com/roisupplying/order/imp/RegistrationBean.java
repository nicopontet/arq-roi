
package com.roisupplying.order.imp;

import com.google.gson.Gson;
import com.roisupplying.dto.CredencialDTO;
import com.roisupplying.dto.ServiceOperationDTO;
import com.roisupplying.dto.ServiceOperationParamDTO;
import com.roisupplying.dto.TypeDataDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Startup
@LocalBean
public class RegistrationBean {
    
    public static final String OPERATION_CREATE_ORDER = "CreateOrder";
    public static final String OPERATION_MODIFY_ORDER = "ModifyOrder";
    public static final String OPERATION_DELETE_ORDER = "DeleteOrder";
    public static final String OPERATION_QUERY_ORDER = "QueryOrder";
    private Gson gson;
    
    public static String TOKEN_KREMLIN;
    public static String TOKEN;
    
    @PostConstruct
    private void init() {
        gson = new Gson();
        loginKremlin();
        registerCreateOrder();
        registerModifyOrder();
        registerDeleteOrder();
        registerQueryOrder();
    }

  
    
    private void loginKremlin(){
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/kremlin-war/auth/login")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(gson.toJson(new CredencialDTO("supplying","supplying"))));
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            String tokenResponse=response.getHeaderString("TOKEN");
            String tokenResponseKremlin=response.getHeaderString("TOKEN_KREMLIN");
            TOKEN = "Bearer "+tokenResponse;
            TOKEN_KREMLIN = tokenResponseKremlin;
        }
    }
    private void registerOperation(ServiceOperationDTO serviceOperation){
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/kremlin-war/services")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(HttpHeaders.AUTHORIZATION, TOKEN)
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
        serviceOperation.setAccessExternal(true);
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
        serviceOperation.setAccessExternal(true);
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
        //int orderId
        parameters.add(new ServiceOperationParamDTO("orderId", "int", 1));
        serviceOperation.setServiceParams(parameters);
        serviceOperation.setTypesData(new ArrayList<TypeDataDTO>());
        serviceOperation.setAccessExternal(true);
        registerOperation(serviceOperation);
    }
   
    public void registerQueryOrder(){
        ServiceOperationDTO serviceOperation = new ServiceOperationDTO();
        serviceOperation.setName(OPERATION_QUERY_ORDER);
        serviceOperation.setTypeReturn("Order");
        serviceOperation.setTypeCommunication("REST");
        serviceOperation.setResources("http://localhost:8080/roiSupplying-war/orders" + "/{orderId}");
        serviceOperation.setAdditionalData(HttpMethod.GET);
        List<ServiceOperationParamDTO> parameters = new ArrayList<ServiceOperationParamDTO>();
        //int orderId
        parameters.add(new ServiceOperationParamDTO("orderId", "int", 1));
        serviceOperation.setServiceParams(parameters);
        serviceOperation.setTypesData(new ArrayList<TypeDataDTO>());
        serviceOperation.setAccessExternal(true);
        registerOperation(serviceOperation);
    }
}
