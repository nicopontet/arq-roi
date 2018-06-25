
package com.roiplanner.dto;

public class ServiceOperationParamDTO {
    String name;
    String typeData;
    int orderParm;

    public ServiceOperationParamDTO(){}
    public ServiceOperationParamDTO(String name, String typeParm, int order) {
        this.name = name;
        this.typeData = typeParm;
        this.orderParm = order;
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
