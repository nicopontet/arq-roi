/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.resources;

import com.google.gson.Gson;
import com.roiplanner.plan.imp.entity.Plan;
import com.roiplanner.plan.imp.PlanBeanLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPlan(String jsonPlan) {
        
        Plan newPlan = gson.fromJson(jsonPlan, Plan.class);
        planBeanLocal.createPlan(newPlan);
        return Response
                .status(Response.Status.OK)
                //.entity(gson.toJson(""))
                .build();
    }
}
