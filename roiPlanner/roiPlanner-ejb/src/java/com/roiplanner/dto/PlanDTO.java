
package com.roiplanner.dto;

public class PlanDTO {
    private int orderId;
    
    public PlanDTO(int orderId){
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
