
package com.roiplanner.plan.persistence;

import com.roiplanner.plan.imp.entity.Plan;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PlanPersistence extends AbstractPersistence<Plan> implements PlanPersistenceLocal {

    @PersistenceContext(unitName = "roiPlanner-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanPersistence() {
        super(Plan.class);
    }
    
}
