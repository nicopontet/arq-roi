
package com.roisupplying.dto;

import java.util.List;

public class ServiceOperationDTO {
    String name;
    String typeReturn;
    List<ServiceOperationParamDTO> serviceParams;   
    String typeCommunication;
    String resources;
    String additionalData;
    List<TypeDataDTO> typesData;
    boolean accessExternal;

    public boolean isAccessExternal() {
        return accessExternal;
    }

    public void setAccessExternal(boolean accessExternal) {
        this.accessExternal = accessExternal;
    }

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
    public ServiceOperationDTO(String name, String typeReturn, List<ServiceOperationParamDTO> serviceParm, String typeCommunication, String resources, String aditionaldata) {

        this.name = name;
        this.typeReturn = typeReturn;
        this.serviceParams = serviceParm;
        this.typeCommunication = typeCommunication;
        this.resources = resources;
        this.additionalData=aditionaldata;
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


    public String getTypeCommunication() {
        return typeCommunication;
    }

    public void setTypeCommunication(String typeCommunication) {
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
