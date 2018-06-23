/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.impl;

import com.kremlin.imp.entity.ServiceOperation;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.kremlin.persistence.ServicePersistenceLocal;
import java.util.List;

/**
 *
 * @author NICO_CUARTO
 */
@Stateless
public class ServiceBean implements ServiceBeanLocal {

    @EJB
    private ServicePersistenceLocal servicePersistenceLocal;
    
    public ServiceBean(){}
    
    @Override
    public void registerService(ServiceOperation operation) {
       servicePersistenceLocal.create(operation);
    }

    @Override
    public List<ServiceOperation> getServices() {
        List<ServiceOperation> services;
        services=servicePersistenceLocal.findAll();
        return services;
    }


}
