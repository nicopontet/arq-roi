
package com.roisupplying.dto;

import com.roisupplying.order.entity.OrderSupplying;
import java.util.Date;

public class OrderSupplyingDTO extends OrderSupplying{
    
    String orderAction;

    public OrderSupplyingDTO(){}
    
    public String getOrderAction() {
        return orderAction;
    }

    public void setOrderAction(String orderAction) {
        this.orderAction = orderAction;
    }
    
}
