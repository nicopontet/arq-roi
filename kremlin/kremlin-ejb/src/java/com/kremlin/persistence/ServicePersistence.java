/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.persistence;


import com.kremlin.imp.entity.ServiceOperation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Brayan
 */
@Stateless
public class ServicePersistence extends AbstractPersistence<ServiceOperation> implements ServicePersistenceLocal {

    @PersistenceContext(unitName = "kremlin-ejbPU")
    private EntityManager em;

   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicePersistence() {
        super(ServiceOperation.class);
    }
    
}
