
package com.kremlin.imp.dto;

import com.google.gson.Gson;

public class QueueDTO {
    String token;
    String action;
    String data;

    public QueueDTO() {
    }

    public QueueDTO(String token, String object,String action) {
        this.token = token;
        this.action = action;
        this.data = object;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String toJson(){
        Gson gson=new Gson();      
        return gson.toJson(this);
    }
    
}
