
package com.kremlin.typecommunication.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RESTImplementation {
    
    public static Response callOperation(String operationUrl,String method,String body){
        Response response = null;
        if(method.toLowerCase().equals("get")){
            response = getOperation(operationUrl);
        }else if(method.toLowerCase().equals("post")){
            response = postOperation(operationUrl,body);
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
