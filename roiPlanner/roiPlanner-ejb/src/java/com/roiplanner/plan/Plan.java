/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.plan;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author NICO_CUARTO
 */
@Entity
public class Plan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int planId;
    boolean canceled;
    boolean approved;

    public Plan(){}
    public Plan(int planId, boolean canceled, boolean approved) {
        this.planId = planId;
        this.canceled = canceled;
        this.approved = approved;
    }
}
