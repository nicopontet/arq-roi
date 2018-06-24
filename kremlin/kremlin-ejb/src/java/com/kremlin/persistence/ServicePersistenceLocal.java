/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.persistence;

import com.kremlin.imp.entity.ServiceOperation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Brayan
 */
@Local
public interface ServicePersistenceLocal {

    void create(ServiceOperation shipment);

    void edit(ServiceOperation shipment);

    void remove(ServiceOperation shipment);

    ServiceOperation find(Object id);

    List<ServiceOperation> findAll();

    List<ServiceOperation> findRange(int[] range);

    int count();
    
    ServiceOperation findServiceOperationByName(String name);
    
}
