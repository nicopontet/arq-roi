
package com.roiplanner.plan.imp;

import com.roiplanner.plan.imp.entity.Plan;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

import javax.ejb.Stateless;
import com.roiplanner.plan.persistence.PlanPersistenceLocal;

@Stateless
public class PlanBean implements PlanBeanLocal {

    @EJB
    private PlanPersistenceLocal planFacade;
    
    public PlanBean(){}
    
    @Override
    public List<Plan> getPlan() {
        planFacade.create(new Plan(1,1,false,false,null));
        planFacade.create(new Plan(2,1,false,true,null));
        return planFacade.findAll();
    }

    @Override
    public void createPlan(Plan plan) {
        planFacade.create(plan);
    }
    
    
}
