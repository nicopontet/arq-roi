
package com.roiplanner.plan.imp;

import com.google.gson.Gson;
import com.roiplanner.dto.ServiceOperationDTO;
import com.roiplanner.dto.ServiceOperationParamDTO;
import com.roiplanner.dto.TypeDataDTO;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
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

    private Gson gson;
    
    @PostConstruct
    private void init() {
        gson = new Gson();
        registerOperation();
    }
    
    public void registerOperation(){
        ServiceOperationDTO serviceOperation = new ServiceOperationDTO();
        serviceOperation.setName("CreatePlan");
        serviceOperation.setTypeReturn("void");
        serviceOperation.setTypeCommunication("REST");
        serviceOperation.setResources("http://localhost:8080/roiPlanner-war/plans");
        serviceOperation.setAdditionalData("POST");
        serviceOperation.setServiceParams(new ArrayList<ServiceOperationParamDTO>());
        serviceOperation.setTypesData(new ArrayList<TypeDataDTO>());
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/kremlin-war/services")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(gson.toJson(serviceOperation)));
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            /*dimensionsDTO = response.readEntity(DimensionsDTO.class);
            return new BigDecimal(
                    dimensionsDTO.getHeight()
                    + dimensionsDTO.getLength()
                    + dimensionsDTO.getWeight());*/
        }
    }
}
