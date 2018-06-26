/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.dto;

import com.google.gson.Gson;

/**
 *
 * @author NICO_CUARTO
 */
public class QueueDTO {
    String token;
    String data;

    public QueueDTO() {
    }

    public QueueDTO(String token, String object) {
        this.token = token;
        this.data = object;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getObject() {
        return data;
    }

    public void setObject(String object) {
        this.data = object;
    }
    public String toJson(){
        Gson gson=new Gson();      
        return gson.toJson(this);
    }
    
}
