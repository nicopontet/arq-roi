/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.imp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author NICO_CUARTO
 */
@Entity
public class ServiceOperation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
    String name;
    String typeReturn;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="service")
    List<ServiceOperationParam> serviceParams;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "application_id")
    Application application;    
    
    @Enumerated(EnumType.STRING)       
    TypeCommunicationEnum typeCommunication;
    String resources;
    String additionalData;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="serviceOperation")
    List<TypeData> typesData;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public List<TypeData> getTypesData() {
        return typesData;
    }

    public void setTypesData(List<TypeData> typesData) {
        this.typesData = typesData;
    }
    
    public ServiceOperation(){}
    public ServiceOperation(int id, String name, String typeReturn, List<ServiceOperationParam> serviceParm, TypeCommunicationEnum typeCommunication, String resource,String additionalData) {
        this.id = id;
        this.name = name;
        this.typeReturn = typeReturn;
        this.serviceParams = serviceParm;
        this.typeCommunication = typeCommunication;
        this.resources = resource;
        this.additionalData=additionalData;
             
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

    public String getTypeReturn() {
        return typeReturn;
    }

    public void setTypeReturn(String typeReturn) {
        this.typeReturn = typeReturn;
    }

    public TypeCommunicationEnum getTypeCommunication() {
        return typeCommunication;
    }

    public void setTypeCommunication(TypeCommunicationEnum typeCommunication) {
        this.typeCommunication = typeCommunication;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public List<ServiceOperationParam> getServiceParams() {
        return serviceParams;
    }

    public void setServiceParams(List<ServiceOperationParam> serviceParams) {
        this.serviceParams = serviceParams;
    }

    
    
}
