/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.plan.imp;

import com.roiplanner.plan.imp.entity.Plan;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NICO_CUARTO
 */
@Local
public interface PlanBeanLocal {
    List<Plan> getPlan();
    
}
