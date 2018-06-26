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
    
    
    public static String TOKEN;
    
    @PostConstruct
    private void init() {
        registerUser();
    }
    
    private void registerUser() {
        
        UserKremlin kremlin =new UserKremlin("kremlin","kremlin",true);
        Application kremlinApp= new Application("kremlinApp");
        kremlinApp.setOwner(kremlin);
        kremlin.setApplication(kremlinApp);
        userBeanLocal.createUser(kremlin);
        
        UserKremlin postman =new UserKremlin("postman","postman",true);
        Application postmanApp= new Application("postmanApp");
        postmanApp.setOwner(postman);
        postman.setApplication(postmanApp);
        userBeanLocal.createUser(postman);
        
        UserKremlin supplying =new UserKremlin("supplying","supplying",false);
        Application supplyingApp= new Application("supplyingApp");
        supplyingApp.setOwner(supplying);
        supplying.setApplication(supplyingApp);
        userBeanLocal.createUser(supplying);
        
        UserKremlin planner =new UserKremlin("planner","planner",false);
        Application plannerApp= new Application("plannerApp");
        plannerApp.setOwner(planner);
        planner.setApplication(plannerApp);
        userBeanLocal.createUser(planner);
        
        UserKremlin calc =new UserKremlin("calc","calc",false);
        Application calcApp= new Application("calcApp");
        calcApp.setOwner(calc);
        calc.setApplication(calcApp);
        userBeanLocal.createUser(calc);
         /* UserKremlin calc =new UserKremlin("calc","calc",false);
            Application calcApp= new Application("calcApp");
            calcApp.setOwner(calc);
            calc.setApplication(calcApp);
            userBeanLocal.createUser(calc);*/   
    }
}
