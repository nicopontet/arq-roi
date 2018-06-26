
package com.roipipelinecalc.imp;



import com.google.gson.Gson;
import com.roipipelinecalc.dto.CredencialDTO;
import com.roipipelinecalc.dto.ServiceOperationDTO;
import com.roipipelinecalc.dto.ServiceOperationParamDTO;
import com.roipipelinecalc.dto.TypeDataDTO;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
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

    public static String TOKEN_KREMLIN;
    public static String TOKEN;
    private Gson gson;
    
    @PostConstruct
    private void init() {
        gson = new Gson();
        loginKremlin();
        registerGetRoute();
    }
    
    private void loginKremlin(){
        Client client = ClientBuilder.newClient();
        Response response = client.target(Constant.URL_LOGIN)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(gson.toJson(new CredencialDTO("calc","calc"))));
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            String tokenResponse=response.getHeaderString(Constant.TOKEN);
            String tokenResponseKremlin=response.getHeaderString(Constant.TOKEN_KREMLIN);
            TOKEN = "Bearer "+tokenResponse;
            TOKEN_KREMLIN = tokenResponseKremlin;
        }
    }
    private void registerOperation(ServiceOperationDTO serviceOperation){
        Client client = ClientBuilder.newClient();
        Response response = client.target(Constant.URL_REGISTER_SERVICE_OPERATION)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(HttpHeaders.AUTHORIZATION, TOKEN)
                .post(Entity.json(gson.toJson(serviceOperation)));
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {     
        }
    }
    public void registerGetRoute(){
        ServiceOperationDTO serviceOperation = new ServiceOperationDTO();
        serviceOperation.setName("GetRouteSupply");
        serviceOperation.setTypeReturn("void");
        serviceOperation.setTypeCommunication("REST");
        serviceOperation.setResources("http://localhost:8080/roiPipelineCalc-war/routes");
        serviceOperation.setAdditionalData("POST");
        serviceOperation.setServiceParams(new ArrayList<ServiceOperationParamDTO>());
        serviceOperation.setTypesData(new ArrayList<TypeDataDTO>());
        registerOperation(serviceOperation);
    }
}
