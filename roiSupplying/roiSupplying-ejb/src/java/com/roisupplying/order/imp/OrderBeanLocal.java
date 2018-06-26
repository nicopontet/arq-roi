package com.roisupplying.order.imp;

import com.roisupplying.order.entity.OrderSupplying;
import javax.ejb.Local;

@Local
public interface OrderBeanLocal {
    OrderSupplying getOrder(int orderId);
}
