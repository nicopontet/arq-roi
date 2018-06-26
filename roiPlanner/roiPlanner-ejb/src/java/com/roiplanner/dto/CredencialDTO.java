/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.dto;

/**
 *
 * @author NICO_CUARTO
 */
public class CredencialDTO {
    private String username;
    private String password;

    public CredencialDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public CredencialDTO() {
    }
    
}
