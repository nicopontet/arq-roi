/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.dto;

import java.io.Serializable;
import java.util.List;


public class TypeDataDTO  {
  
    String name;
    //List<TypeDataDTO> typeParams;
    ServiceOperationDTO serviceOperation;   
    
    List<TypeDataDTO> typeParams;
    transient TypeDataDTO parent;

   

    public TypeDataDTO(){}
    public TypeDataDTO(String name, List<TypeDataDTO> typeparams,ServiceOperationDTO serviceOperation) {
   
        this.name = name;
        this.typeParams = typeparams;
        this.serviceOperation=serviceOperation;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TypeDataDTO> getTypeparams() {
        return typeParams;
    }

    public void setTypeparams(List<TypeDataDTO> typeparams) {
        this.typeParams = typeparams;
    }
     public ServiceOperationDTO getServiceOperation() {
        return serviceOperation;
    }

    public void setServiceOperation(ServiceOperationDTO serviceOperation) {
        this.serviceOperation = serviceOperation;
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
