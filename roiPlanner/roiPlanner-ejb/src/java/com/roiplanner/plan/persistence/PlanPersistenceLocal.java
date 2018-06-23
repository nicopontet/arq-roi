
package com.roiplanner.plan.persistence;

import com.roiplanner.plan.imp.entity.Plan;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PlanPersistenceLocal {

    void create(Plan shipment);

    void edit(Plan shipment);

    void remove(Plan shipment);

    Plan find(Object id);

    List<Plan> findAll();

    List<Plan> findRange(int[] range);

    int count();
    
}
