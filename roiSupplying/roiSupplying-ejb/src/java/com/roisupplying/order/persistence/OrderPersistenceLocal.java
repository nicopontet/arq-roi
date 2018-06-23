
package com.roisupplying.order.persistence;

import com.roisupplying.order.entity.OrderSupplying;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OrderPersistenceLocal {
    
    void create(OrderSupplying shipment);

    void edit(OrderSupplying shipment);

    void remove(OrderSupplying shipment);

    OrderSupplying find(Object id);

    List<OrderSupplying> findAll();

    List<OrderSupplying> findRange(int[] range);

    int count();
}
