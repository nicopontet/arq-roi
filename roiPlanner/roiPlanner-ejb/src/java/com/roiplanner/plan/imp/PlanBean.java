/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.plan.imp;

import com.roiplanner.plan.imp.entity.Plan;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

import javax.ejb.Stateless;
import com.roiplanner.plan.persistence.PlanPersistenceLocal;

/**
 *
 * @author NICO_CUARTO
 */
@Stateless
public class PlanBean implements PlanBeanLocal {

    @EJB
    private PlanPersistenceLocal planFacade;
    
    public PlanBean(){}
    
    @Override
    public List<Plan> getPlan() {
        planFacade.create(new Plan(1,false,false));
        planFacade.create(new Plan(2,false,true));
        return planFacade.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
