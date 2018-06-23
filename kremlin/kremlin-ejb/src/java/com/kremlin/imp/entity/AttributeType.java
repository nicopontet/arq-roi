/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.imp.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AttributeType implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String atributeTypeData;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "attributeType")
    TypeData typedata;

    public AttributeType() {
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

    public TypeData getTypedata() {
        return typedata;
    }

    public void setTypedata(TypeData typedata) {
        this.typedata = typedata;
    } 

    public String getAtributeDataType() {
        return atributeTypeData;
    }

    public void setAtributeDataType(String atributeTypeData) {
        this.atributeTypeData = atributeTypeData;
    }
    
}
