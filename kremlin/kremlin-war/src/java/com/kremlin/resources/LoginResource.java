/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.resources;


import com.google.gson.Gson;

import com.kremlin.dto.ServiceOperationDTO;
import com.kremlin.imp.entity.ServiceOperation;
import com.kremlin.typecommunication.impl.JMSImplementation;
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
public class LoginResource {
   
    @EJB
    private ServiceBeanLocal serviceBeanLocal;
    
    private final Gson gson;
    private final ModelMapper modelMapper;
    
    public LoginResource() {
        this.gson = new Gson();
        this.modelMapper=new ModelMapper();
        
        
    }
    
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response callService(String jsonBody) {
        
        JMSImplementation jmsImp = new JMSImplementation("jms/RoiSupplyingConnectionFactory","jms/RoiSupplyingQueue");
        jmsImp.sendMessage(jsonBody);
        
        return Response
                .status(Response.Status.OK)
                .build();
    }
}
