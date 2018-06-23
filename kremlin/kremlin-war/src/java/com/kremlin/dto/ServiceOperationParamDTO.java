/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.dto;

import com.kremlin.imp.entity.ServiceOperation;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author NICO_CUARTO
 */
class ServiceOperationParamDTO {
    int id;
    String name;
    String typeData;
    int orderParm;

    public ServiceOperationParamDTO(){}
    public ServiceOperationParamDTO(int id, String name, String typeParm, int order) {
        this.id = id;
        this.name = name;
        this.typeData = typeParm;
        this.orderParm = order;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeParm() {
        return typeData;
    }

    public void setTypeParm(String typeParm) {
        this.typeData = typeParm;
    }

    public int getOrder() {
        return orderParm;
    }

    public void setOrder(int order) {
        this.orderParm = order;
    }
}
