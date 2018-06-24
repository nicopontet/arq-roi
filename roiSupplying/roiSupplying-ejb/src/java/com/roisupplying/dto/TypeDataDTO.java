
package com.roisupplying.dto;

import java.util.List;

public class TypeDataDTO {
   String name;
   ServiceOperationDTO serviceOperation;   
   List<AttributeTypeDTO> attributesType;

   

    public TypeDataDTO(){}

    public TypeDataDTO(String name, ServiceOperationDTO serviceOperation, List<AttributeTypeDTO> attributesType) {
        this.name = name;
        this.serviceOperation = serviceOperation;
        this.attributesType = attributesType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceOperationDTO getServiceOperation() {
        return serviceOperation;
    }

    public void setServiceOperation(ServiceOperationDTO serviceOperation) {
        this.serviceOperation = serviceOperation;
    }

    public List<AttributeTypeDTO> getAttributesType() {
        return attributesType;
    }

    public void setAttributesType(List<AttributeTypeDTO> attributesType) {
        this.attributesType = attributesType;
    }
}
