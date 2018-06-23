/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.plan.imp;

import javax.ejb.Local;

/**
 *
 * @author Fede2
 */
@Local
public interface PlannerMessageSenderBeanLocal {
    public void sendMessage(String message);
}
