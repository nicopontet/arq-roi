/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.persistence;

import com.kremlin.imp.entity.UserKremlin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Brayan
 */
@Local
public interface UserPersistenceLocal {

    void create(UserKremlin shipment);

    void edit(UserKremlin shipment);

    void remove(UserKremlin shipment);

    UserKremlin find(Object id);

    List<UserKremlin> findAll();

    List<UserKremlin> findRange(int[] range);

    int count();
    
    UserKremlin findUserByName(String name);
    
}
