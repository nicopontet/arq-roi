/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.auth.imp;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author NICO_CUARTO
 */
@Entity
public class Token implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String token;
    String tokenKremin;
    String userName;
    String date; 

    public Token() {
    }

    public Token(String token,String user) {
        this.token = token;
        this.userName = user;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.date=dateFormat.format(date);
        
    }

    public String getTokenKremin() {
        return tokenKremin;
    }

    public void setTokenKremin(String tokenKremin) {
        this.tokenKremin = tokenKremin;
    }

    public Token(String token, String tokenKremin, String userName) {
        this.token = token;
        this.tokenKremin = tokenKremin;
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    

    
    
}
