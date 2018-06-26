/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.impl;

import com.kremlin.imp.entity.ServiceOperation;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.core.Response;

/**
 *
 * @author NICO_CUARTO
 */
@Local
public interface ServiceBeanLocal {
    void registerService(ServiceOperation service) throws InvalidNameServiceOperationException;
    List<ServiceOperation> getServices();
    Response sendData(String serviceOperationName,String token,String jsonBody) throws CallServiceOperationException;
    public ServiceOperation getServiceOperationByName(String name);
}
