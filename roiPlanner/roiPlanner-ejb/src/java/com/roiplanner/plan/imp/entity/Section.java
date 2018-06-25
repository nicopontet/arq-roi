
package com.roiplanner.plan.imp.entity;

public class Section {
    int sectionId;
    int sourceId;
    int actuatorId;
    
    public Section(){}

    public Section(int sectionId, int sourceId, int actuatorId) {
        this.sectionId = sectionId;
        this.sourceId = sourceId;
        this.actuatorId = actuatorId;
    }
    
    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getActuatorId() {
        return actuatorId;
    }

    public void setActuatorId(int actuatorId) {
        this.actuatorId = actuatorId;
    }
}
