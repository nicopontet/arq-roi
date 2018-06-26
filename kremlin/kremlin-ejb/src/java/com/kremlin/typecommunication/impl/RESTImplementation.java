
package com.kremlin.typecommunication.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kremlin.imp.entity.ServiceOperation;
import com.kremlin.imp.entity.ServiceOperationParam;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RESTImplementation {
    private static final String AUTHENTICATION_SCHEME = "Bearer ";
    public static Response callOperation(String token,ServiceOperation service,String body){
        Response response = null;
        if(service.getAdditionalData().toLowerCase().equals("get")){
            response = getOperation(token,service,body);
        }else if(service.getAdditionalData().toLowerCase().equals("post")){
            response = postOperation(token,service.getResources(),body);
        }
        return response;
    }
    
    public static Response postOperation(String token,String uri,String body){
        Client client = ClientBuilder.newClient();
        Response response = client.target(uri)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(HttpHeaders.AUTHORIZATION, AUTHENTICATION_SCHEME + token)
                .post(Entity.json(body));
        return response;
    }
    
    public static Response getOperation(String token,ServiceOperation service,String body){
        Gson gson = new Gson();
        Client client = ClientBuilder.newClient();
        String uri = service.getResources();
        if(!body.isEmpty()){
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(body).getAsJsonObject();
            for(ServiceOperationParam sop : service.getServiceParams()){
                String value = jsonObject.get(sop.getName()).getAsString();
                uri = uri.replace("{"+sop.getName()+"}",value);
            }
        }
        Response response = client.target(uri)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(HttpHeaders.AUTHORIZATION, AUTHENTICATION_SCHEME + token)
                .get();
        return response;
    }
}
