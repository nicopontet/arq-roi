/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.plan.persistence;

import com.roiplanner.plan.imp.entity.Plan;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Brayan
 */
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
