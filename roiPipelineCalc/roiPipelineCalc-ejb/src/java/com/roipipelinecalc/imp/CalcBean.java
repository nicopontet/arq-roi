/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roipipelinecalc.imp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.roipipelinecalc.dto.RouteDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author NICO_CUARTO
 */
@Stateless
public class CalcBean implements CalcBeanLocal {
    private static final String URL_GET_ROUTE_SUPPLY="https://pipeline-calculator-api.herokuapp.com/pipeline-route/service/id";
    private Gson gson=new Gson();
    public CalcBean() {
        
    }

    
    @Override
    public RouteDTO getRouteSupply() {
        
        
           Client client = ClientBuilder.newClient();
           Response response = ExternalOperationsHandler.callOperation(URL_GET_ROUTE_SUPPLY, "POST", "");

           if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                String routesString =response.readEntity(String.class);
                RouteDTO routes = gson.fromJson(routesString, RouteDTO.class);
                return routes;
           }else{
               return null;
                 }
       
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
