/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roipipelinecalc.filter;

import com.roipipelinecalc.imp.RegistrationBean;
import java.io.IOException;
import javax.annotation.Priority;

import javax.ws.rs.container.*;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Priorities;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@OnlyKremlin
@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizeOnlyKremlinFilter implements ContainerRequestFilter{

    @Context
    private HttpServletRequest request;
    @Context
    private ResourceInfo resourceInfo;
    
    private static final String AUTHENTICATION_SCHEME = "Bearer";
    
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
       // String url=request.getRequestURL().toString();
        String authorizationHeader= requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
                
       //Verificar que venga un token (Bearer)
       if (!isTokenBasedAuthentication(authorizationHeader)) {
            abort(requestContext,Response.Status.UNAUTHORIZED);
            return;
        }

        // Extraigo token
        String token = authorizationHeader
                            .substring(AUTHENTICATION_SCHEME.length()).trim();
        if (!RegistrationBean.TOKEN_KREMLIN.equals(token)) {
           abort(requestContext,Response.Status.UNAUTHORIZED);
        }
        
        
    }  
    private boolean isTokenBasedAuthentication(String authorizationHeader) {

        return authorizationHeader != null && authorizationHeader.toLowerCase()
                    .startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }

    private void abort(ContainerRequestContext requestContext,Response.Status httpStatus) {
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .build());
    }
    
    
   
        
    
   

        
 }
    

