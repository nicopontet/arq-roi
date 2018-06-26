/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.communication;

/**
 *
 * @author NICO_CUARTO
 */
public class CommunicationRouteSupplyErrorException extends Exception{
  private static String MESSAGE="Error when obtaining supply route";
    public CommunicationRouteSupplyErrorException() {
        super(MESSAGE);
    }
     public CommunicationRouteSupplyErrorException(String msg) {
         super(msg);
     
    }
    
}
