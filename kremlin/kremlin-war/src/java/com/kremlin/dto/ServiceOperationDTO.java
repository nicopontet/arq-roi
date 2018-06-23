/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.dto;

import java.util.List;
import com.kremlin.imp.entity.TypeCommunicationEnum;
import com.kremlin.imp.entity.TypeData;

/**
 *
 * @author NICO_CUARTO
 */
public class ServiceOperationDTO {

    int id;
    String name;
    String typeReturn;
    List<ServiceOperationParamDTO> serviceParams;   
    TypeCommunicationEnum typeCommunication;
    String resources;
    String additionalData;
    List<TypeDataDTO> typesData;

    public List<ServiceOperationParamDTO> getServiceParams() {
        return serviceParams;
    }

    public void setServiceParams(List<ServiceOperationParamDTO> serviceParams) {
        this.serviceParams = serviceParams;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public List<TypeDataDTO> getTypesData() {
        return typesData;
    }

    public void setTypesData(List<TypeDataDTO> typesData) {
        this.typesData = typesData;
    }
    
    public ServiceOperationDTO(){}
    public ServiceOperationDTO(int id, String name, String typeReturn, List<ServiceOperationParamDTO> serviceParm, TypeCommunicationEnum typeCommunication, String resources, String aditionaldata) {
        this.id = id;
        this.name = name;
        this.typeReturn = typeReturn;
        this.serviceParams = serviceParm;
        this.typeCommunication = typeCommunication;
        this.resources = resources;
        this.additionalData=aditionaldata;
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

    public List<ServiceOperationParamDTO> getListParmOperation() {
        return serviceParams;
     
    }

    public void setListParmOperation(List<ServiceOperationParamDTO> listParmOperation) {
        this.serviceParams = listParmOperation;
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

    public List<ServiceOperationParamDTO> getServiceParm() {
        return serviceParams;
    }

    public void setServiceParm(List<ServiceOperationParamDTO> serviceParm) {
        this.serviceParams = serviceParm;
    }

    public String getAditionaldata() {
        return additionalData;
    }

    public void setAditionaldata(String aditionaldata) {
        this.additionalData = aditionaldata;
    }
    
    
}
