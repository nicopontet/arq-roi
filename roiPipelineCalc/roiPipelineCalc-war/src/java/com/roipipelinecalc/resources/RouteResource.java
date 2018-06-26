/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roipipelinecalc.resources;

import com.google.gson.Gson;
import com.roipipelinecalc.dto.RouteDTO;
import com.roipipelinecalc.filter.OnlyKremlin;
import com.roipipelinecalc.imp.CalcBean;
import com.roipipelinecalc.imp.CalcBeanLocal;
import com.roipipelinecalc.imp.RegistrationBean;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author NICO_CUARTO
 */
@Path("routes")
public class RouteResource {
   
    @EJB
    private CalcBeanLocal calcBeanLocal;
    
    private final Gson gson;
    
    public RouteResource() {
        this.gson = new Gson();
    }
    
    @OnlyKremlin
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRouteSupply() {
        
       try{
           RouteDTO route=calcBeanLocal.getRouteSupply();
            return Response
                .status(Response.Status.OK)
                .entity(gson.toJson(route))
                .build();
       }catch(NullPointerException ex){
            return Response
                .status(Response.Status.BAD_REQUEST)
                .header(HttpHeaders.AUTHORIZATION,RegistrationBean.TOKEN)
                .entity("Error when obtaining supply route")
                .build();
       } 
    }
}
