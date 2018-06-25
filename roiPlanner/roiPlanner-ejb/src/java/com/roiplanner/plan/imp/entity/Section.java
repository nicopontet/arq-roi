
package com.roiplanner.plan.imp.entity;

public class Section {
    int sectionId;
    int serviceStation;
    int actuator;
    
    public Section(){}

    public Section(int sectionId, int serviceStation, int actuator) {
        this.sectionId = sectionId;
        this.serviceStation = serviceStation;
        this.actuator = actuator;
    }
    
    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getServiceStation() {
        return serviceStation;
    }

    public void setServiceStation(int serviceStation) {
        this.serviceStation = serviceStation;
    }

    public int getActuator() {
        return actuator;
    }

    public void setActuator(int actuator) {
        this.actuator = actuator;
    }
    
    
}
