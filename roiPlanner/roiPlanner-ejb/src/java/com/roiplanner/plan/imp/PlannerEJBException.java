/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.plan.imp;

/**
 *
 * @author NICO_CUARTO
 */
public class PlannerEJBException extends Exception{
    private static String MESSAGE="Error planner EJB";
    public PlannerEJBException() {
        super(MESSAGE);
    }
    
     public PlannerEJBException(String msg) {
         super(msg);
     
    }
}
