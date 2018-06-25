
package com.roisupplying.order.imp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.roisupplying.dto.ServiceOperationDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ExternalOperationsHandler {
    
    public static List<ServiceOperationDTO> getOperations(){
        Response response = callOperation("","get","");
        String listServices = response.readEntity(String.class);
        JsonArray jsonArray = new JsonParser().parse(listServices).getAsJsonArray();
        Gson gson = new Gson();
        List<ServiceOperationDTO> operations = new ArrayList<ServiceOperationDTO>();
        for(int i=0;i<jsonArray.size();i++){
            ServiceOperationDTO sop = gson.fromJson(jsonArray.get(i),ServiceOperationDTO.class);
            operations.add(sop);
        }
        return operations;
    }
    
    public static Response callOperation(String operation,String method,String body){
        Response response = null;
        String uri = "http://localhost:8080/kremlin-war/services";
        if(!operation.isEmpty()) uri += "/" + operation;
        if(method.toLowerCase().equals("get")){
            response = getOperation(uri);
        }else if(method.toLowerCase().equals("post")){
            response = postOperation(uri,body);
        }
        return response;
    }
    
    public static Response postOperation(String uri,String body){
        Client client = ClientBuilder.newClient();
        Response response = client.target(uri)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(body));
        return response;
    }
    
    public static Response getOperation(String uri){
        Client client = ClientBuilder.newClient();
        Response response = client.target(uri)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
        return response;
    }
}
