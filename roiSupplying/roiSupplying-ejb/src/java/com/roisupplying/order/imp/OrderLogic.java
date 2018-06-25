
package com.roisupplying.order.imp;

import com.roisupplying.order.entity.OrderSupplying;
import java.util.Date;

public class OrderLogic {
    
    public static OrderSupplying updateOrder(OrderSupplying baseOrder,OrderSupplying newOrder){
        if(newOrder != null){
            if(newOrder.getClientId() != 0) baseOrder.setClientId(newOrder.getClientId());
            if(newOrder.getStartDate() != null) baseOrder.setStartDate(newOrder.getStartDate());
            if(newOrder.getHiredVolume()!= 0) baseOrder.setHiredVolume(newOrder.getHiredVolume());
            if(newOrder.getServiceStationNumber()!= 0) baseOrder.setServiceStationNumber(newOrder.getServiceStationNumber());
            if(newOrder.getClosingBillingDate() != null) baseOrder.setClosingBillingDate(newOrder.getClosingBillingDate());
        }
        return baseOrder;
    }
}
