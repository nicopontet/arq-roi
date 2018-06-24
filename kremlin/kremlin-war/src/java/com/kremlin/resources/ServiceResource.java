/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.resources;


import com.google.gson.Gson;

import com.kremlin.dto.ServiceOperationDTO;
import com.kremlin.imp.entity.ServiceOperation;
import com.kremlin.impl.JMSImplementation;
import com.kremlin.impl.ServiceBeanLocal;
import java.lang.reflect.Type;

import java.util.List;
import javax.ejb.EJB;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;




/**
 *
 * @author NICO_CUARTO
 */
@Path("services")
public class ServiceResource {
   
    @EJB
    private ServiceBeanLocal serviceBeanLocal;
    
    private final Gson gson;
    private final ModelMapper modelMapper;
    
    public ServiceResource() {
        this.gson = new Gson();
        this.modelMapper=new ModelMapper();
        
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerService(String jsonServices) {
        
        //operationsBeanLocal.RegisterService(operation);
        ServiceOperation op=gson.fromJson(jsonServices, ServiceOperation.class);
        serviceBeanLocal.registerService(op);
        return Response
                .status(Response.Status.OK)
                .build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServices() {
        
        List<ServiceOperation> services = serviceBeanLocal.getServices();
        
        //mapea y lo convierte a DTO
        Type listType = new TypeToken<List<ServiceOperationDTO>>() {}.getType();
        List<ServiceOperationDTO> servicesDTO=modelMapper.map(services, listType);

        if (services == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response
                .status(Response.Status.OK)
                .entity(gson.toJson(servicesDTO))
                .build();

    }
    
    @POST
    @Path("/{operationName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response callService(@PathParam("operationName") String operationName, String jsonBody) {
        
        JMSImplementation jmsImp = new JMSImplementation("jms/RoiSupplyingConnectionFactory","jms/RoiSupplyingQueue");
        jmsImp.sendMessage(jsonBody);
        
        return Response
                .status(Response.Status.OK)
                .build();
    }
}
