/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.auth.persistence.imp;

import com.kremlin.auth.imp.Token;
import com.kremlin.auth.imp.Token;
import com.kremlin.imp.entity.UserKremlin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Brayan
 */
@Local
public interface TokenPersistenceLocal {

    Token createToken(Token shipment);

    void edit(Token shipment);

    void remove(Token shipment);

    Token find(Object id);

    List<Token> findAll();

    List<Token> findRange(int[] range);

    int count();
    Token findTokenByNro(String tokenNro);
    Token findTokenByUser(String userName);
    
    
}
