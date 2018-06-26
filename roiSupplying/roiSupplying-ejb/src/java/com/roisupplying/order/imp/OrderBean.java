package com.roisupplying.order.imp;

import com.roisupplying.order.entity.OrderSupplying;
import com.roisupplying.order.persistence.OrderPersistence;
import com.roisupplying.order.persistence.OrderPersistenceLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrderBean implements OrderBeanLocal {

    @EJB
    OrderPersistenceLocal orderPersistenceLocal;
    
    public OrderBean(){}
    
    public OrderSupplying getOrder(int orderId){
        OrderSupplying order = orderPersistenceLocal.find(orderId);
        return order;
    }
}
