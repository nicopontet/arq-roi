/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.imp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author NICO_CUARTO
 */
@Entity
public class TypeData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="typedata_id")
    int id;
    String name;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name= "child_typedata_id")
    List<TypeData> typeParams;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "service_operation_id")
    ServiceOperation serviceOperation;    

    public TypeData(){}
    public TypeData(int id, String name, List<TypeData> typeparams) {
        this.id = id;
        this.name = name;
        this.typeParams = typeparams;
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

    public List<TypeData> getTypeparams() {
        return typeParams;
    }

    public void setTypeparams(List<TypeData> typeparams) {
        this.typeParams = typeparams;
    }
    
}
/*tipo datos basico
1 - Int  - Integar
2 - Float - Float
3 - Double
2 - Bool
3 - String
4 - Char
5 - DateTime
*/
/*tipos datos especificos, propios de cada operacion

*/
