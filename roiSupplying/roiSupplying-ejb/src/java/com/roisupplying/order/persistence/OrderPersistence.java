
package com.roisupplying.order.persistence;

import com.roisupplying.order.entity.OrderSupplying;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderPersistence extends AbstractPersistence<OrderSupplying> implements OrderPersistenceLocal {

    @PersistenceContext(unitName = "roiSupplying-ejbPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public OrderPersistence() {
        super(OrderSupplying.class);
    }
}
