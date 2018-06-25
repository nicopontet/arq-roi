/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.auth.resource.filter;

import com.kremlin.auth.imp.AccessBy;
import com.kremlin.auth.imp.AuthBeanLocal;
import com.kremlin.auth.imp.AuthException;
import com.kremlin.auth.imp.AuthUtils;
import com.kremlin.auth.imp.InvalidNameServiceOperationException;
import com.kremlin.auth.imp.LoginUnsusefullException;
import com.kremlin.auth.imp.TypeAccess;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Priority;
import javax.ejb.EJB;

import javax.ws.rs.container.*;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Authenticate
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticateFilter implements ContainerRequestFilter{

    @Context
    private HttpServletRequest request;
    @Context
    private ResourceInfo resourceInfo;
    
    private static final String AUTHENTICATION_SCHEME = "Bearer";
    
    @EJB
    AuthBeanLocal authBeanLocal;
    
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
        try {
                authBeanLocal.validateToken(token);
        } catch (AuthException e) {
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
    

