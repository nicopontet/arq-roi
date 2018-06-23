/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.imp.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author NICO_CUARTO
 */
@Entity
public class ServiceOperationParam implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String typeData;
    int orderParm;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "service_operation_id")
    ServiceOperation service;
    
    

    public ServiceOperationParam(){}
    public ServiceOperationParam(int id, String name, String typeParm, int order) {
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
