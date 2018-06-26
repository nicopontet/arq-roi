
package com.roisupplying.dto;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getData() {
        return data;
    }

    public void setData(String object) {
        this.data = object;
    }
    
}
