/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.dto;

import com.kremlin.imp.entity.AttributeType;
import java.io.Serializable;
import java.util.List;


public class TypeDataDTO  {
  
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
/*tipo datos basico
1 - Int  - Integar
2 - Float - Float
3 - Double
2 - Bool
3 - String
4 - Char
5 - DateTime
*/
/*tipos datos especificos, propios de cada operacion

*/
