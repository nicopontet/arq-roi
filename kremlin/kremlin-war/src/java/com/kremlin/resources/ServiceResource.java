/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.resources;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.kremlin.auth.imp.AccessBy;
import com.kremlin.auth.imp.TypeAccess;

import com.kremlin.dto.ServiceOperationDTO;
import com.kremlin.auth.resource.filter.Secured;
import com.kremlin.impl.InitializationBean;
import com.kremlin.dto.QueueDTO;
import com.kremlin.imp.entity.ServiceOperation;
import com.kremlin.impl.CallServiceOperationException;
import com.kremlin.impl.InvalidNameServiceOperationException;
import com.kremlin.impl.ServiceBeanLocal;
import java.lang.reflect.Type;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//@Secured({TypeAccess.INTERNAL})
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
    @Secured(typeAccess=TypeAccess.INTERNAL)
    public Response registerService(String jsonServices) {
         
       //si el usuario es externo para fuera. No autorizado
        ServiceOperation op=gson.fromJson(jsonServices, ServiceOperation.class);
        try {
            serviceBeanLocal.registerService(op);
            return Response
                .status(Response.Status.OK)
                .build();
        } catch (InvalidNameServiceOperationException ex) {
            Logger.getLogger(ServiceResource.class.getName()).log(Level.SEVERE, null, ex);
             return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(ex.getMessage())
                .build();
        }
       
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Secured(typeAccess=TypeAccess.EXTERNAL,accessBy=AccessBy.ANNOTATION)
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
    @Secured(typeAccess=TypeAccess.EXTERNAL,accessBy=AccessBy.OPERATION_NAME)
    public Response callService(@PathParam("operationName") String operationName, String jsonBody) {
        
        try { 
            QueueDTO sendQueueDTO=new QueueDTO(InitializationBean.TOKEN,jsonBody);
            serviceBeanLocal.sendData(operationName, sendQueueDTO.toJson());
              return Response
                .status(Response.Status.OK)
                .build();
        } catch (CallServiceOperationException ex) {
            Logger.getLogger(ServiceResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(ex.getMessage())
                .build();
        }
        
      
    }
}
