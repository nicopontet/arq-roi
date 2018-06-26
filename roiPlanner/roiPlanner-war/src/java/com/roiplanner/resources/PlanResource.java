/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.resources;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.roiplanner.communication.CommunicationRouteSupplyErrorException;
import com.roiplanner.dto.RouteDTO;
import com.roiplanner.filter.OnlyKremlin;
import com.roiplanner.plan.imp.entity.Plan;
import com.roiplanner.plan.imp.PlanBeanLocal;
import com.roiplanner.plan.imp.PlannerEJBException;
import com.roiplanner.plan.imp.RegistrationBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author NICO_CUARTO
 */
@Path("plans")
public class PlanResource {
   
    @EJB
    private PlanBeanLocal planBeanLocal;
    
    private final Gson gson;
    
    public PlanResource() {
        this.gson = new Gson();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlans() throws NamingException {
        List<Plan> plans = planBeanLocal.getPlan();

        if (plans == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        
        return Response
                .status(Response.Status.OK)
                .entity(gson.toJson(plans))
                .build();
    }
    @OnlyKremlin
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPlan(String jsonPlan) {
        
        Plan newPlan = gson.fromJson(jsonPlan, Plan.class);
        
        try {
            planBeanLocal.createPlan(newPlan);
            return Response
                    .status(Response.Status.OK)
                    .build();
        } catch (PlannerEJBException|CommunicationRouteSupplyErrorException ex) {
            Logger.getLogger(PlanResource.class.getName()).log(Level.SEVERE, null, ex);
             return Response
                .status(Response.Status.BAD_REQUEST)
                .header(HttpHeaders.AUTHORIZATION,RegistrationBean.TOKEN)
                .entity(ex.getMessage())
                .build();
        }
    }
    
}
