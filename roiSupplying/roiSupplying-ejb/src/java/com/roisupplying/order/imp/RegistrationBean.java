
package com.roisupplying.order.imp;

import com.google.gson.Gson;
import com.roisupplying.dto.ServiceOperationDTO;
import com.roisupplying.dto.ServiceOperationParamDTO;
import com.roisupplying.dto.TypeDataDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
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
        serviceOperation.setName("CreateOrder");
        serviceOperation.setTypeReturn("void");
        serviceOperation.setTypeCommunication("JMS");
        serviceOperation.setResources("jms/RoiSupplyingConnectionFactory");
        serviceOperation.setAdditionalData("jms/RoiSupplyingQueue");
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
