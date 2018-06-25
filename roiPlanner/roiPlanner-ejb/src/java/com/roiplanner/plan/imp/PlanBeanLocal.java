
package com.roiplanner.plan.imp;

import com.roiplanner.plan.imp.entity.Plan;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PlanBeanLocal {
    List<Plan> getPlan();
    void createPlan(Plan plan);
}
