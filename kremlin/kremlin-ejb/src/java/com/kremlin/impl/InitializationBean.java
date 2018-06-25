/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.impl;

import com.kremlin.imp.entity.Application;
import com.kremlin.imp.entity.UserKremlin;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Singleton
@Startup
@LocalBean
public class InitializationBean {
    
    @EJB
    UserBeanLocal userBeanLocal;
    
    @PostConstruct
    private void init() {
        registerUser();
    }

    private void registerUser() {
        UserKremlin postman =new UserKremlin("postman","postman",true);
        Application postmanApp= new Application("postmanApp");
        postmanApp.setOwner(postman);
        postman.setApplication(postmanApp);
        userBeanLocal.createUser(postman);
    }
}
