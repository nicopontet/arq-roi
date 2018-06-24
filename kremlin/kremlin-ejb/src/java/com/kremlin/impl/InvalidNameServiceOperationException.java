/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.impl;


/**
 *
 * @author NICO_CUARTO
 */
public class InvalidNameServiceOperationException extends Exception {
    static final String MESSAGE="Invalid name service opertation.";
    public InvalidNameServiceOperationException() {
      super(MESSAGE);    
    }   
}
