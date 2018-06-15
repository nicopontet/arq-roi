/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.presist;

import com.roiplanner.plan.Plan;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Brayan
 */
@Local
public interface PlanFacadeLocal {

    void create(Plan shipment);

    void edit(Plan shipment);

    void remove(Plan shipment);

    Plan find(Object id);

    List<Plan> findAll();

    List<Plan> findRange(int[] range);

    int count();
    
}
