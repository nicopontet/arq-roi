
package com.roiplanner.plan.imp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int planId;
    private int orderId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="plan")
    private List<Section> sections;
    private boolean canceled;
    private boolean approved;

    public Plan(){}

    public Plan(int orderId) {
        this.orderId = orderId;
        boolean canceled=false;
        boolean approved=false;
        sections= new ArrayList<Section>(); 
    }
    
    
    public Plan(int planId,int orderId,boolean canceled, boolean approved,List<Section> sections) {
        this.planId = planId;
        this.canceled = canceled;
        this.approved = approved;
        this.sections = sections;
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    
    
}
