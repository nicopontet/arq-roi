/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.resources;


import com.google.gson.Gson;
import com.kremlin.auth.imp.AuthBean;
import com.kremlin.auth.imp.AuthBeanLocal;
import com.kremlin.auth.imp.AuthException;
import com.kremlin.auth.imp.LoginUnsusefullException;
import com.kremlin.auth.imp.Token;

import com.kremlin.dto.UserDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.modelmapper.ModelMapper;



@Path("/auth")
public class LoginResource {
   
    @EJB
    private AuthBeanLocal authBeanLocal;
    
    private final Gson gson;
    private final ModelMapper modelMapper;

    public LoginResource() {
        this.gson = new Gson();
        this.modelMapper=new ModelMapper();    
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(String jsonBody) {
        UserDTO user=gson.fromJson(jsonBody, UserDTO.class);
        try {
            
            //si es una aplicacion externa
            Token token=authBeanLocal.authentication(user.getUsername(), user.getPassword());
           
            return Response
                .status(Response.Status.OK)
                .header("TOKEN", token.getToken())
                .build();
            
            //si es aplicacion interna
           /*  return Response
                .status(Response.Status.OK)
                .header("TOKEN",  RegistrationBean.Token)
                .build();*/
           
        } catch (LoginUnsusefullException ex) {
            Logger.getLogger(LoginResource.class.getName()).log(Level.INFO, null, ex);
             return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(ex.getMessage())
                .build();
        } catch (AuthException ex) {
            Logger.getLogger(LoginResource.class.getName()).log(Level.SEVERE, null, ex);
             return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(ex.getMessage())
                .build();
        } 
     
       
    }
}
