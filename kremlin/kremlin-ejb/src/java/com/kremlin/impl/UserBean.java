/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.impl;

import com.kremlin.imp.entity.UserKremlin;
import com.kremlin.persistence.ServicePersistenceLocal;
import com.kremlin.persistence.UserPersistenceLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.registry.infomodel.User;

/**
 *
 * @author NICO_CUARTO
 */
@Stateless
public class UserBean implements UserBeanLocal {
    @EJB
    private UserPersistenceLocal userPersistenceLocal;
    
    public UserBean(){}

    @Override
    public UserKremlin getUserByName(String name) {
        UserKremlin user=userPersistenceLocal.findUserByName(name);
        return user;
    }

    @Override
    public void createUser(UserKremlin user) {
        userPersistenceLocal.create(user);
    }
}
