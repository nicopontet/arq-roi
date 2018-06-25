/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.imp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author NICO_CUARTO
 */
@Entity
public class Application implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="application")
    UserKremlin owner;
   // int UserId
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY,mappedBy="application")
    List<ServiceOperation> servicesoperations;

    public Application() {
    }

    public Application(String name) {
        this.name = name;
        this.owner=null;
        this.servicesoperations=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserKremlin getOwner() {
        return owner;
    }

    public void setOwner(UserKremlin owner) {
        this.owner = owner;
    }

    public List<ServiceOperation> getServicesoperations() {
        return servicesoperations;
    }

    public void setServicesoperations(List<ServiceOperation> servicesoperations) {
        this.servicesoperations = servicesoperations;
    }
    
    
}
