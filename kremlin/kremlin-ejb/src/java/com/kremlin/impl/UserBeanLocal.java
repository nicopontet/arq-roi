/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.impl;

import com.kremlin.imp.entity.UserKremlin;
import javax.ejb.Local;


/**
 *
 * @author NICO_CUARTO
 */
@Local
public interface UserBeanLocal {
     void createUser(UserKremlin user);
     UserKremlin getUserByName(String name);
}
