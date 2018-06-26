
package com.roiplanner.plan.imp.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Section implements Serializable {
    @Id
    int sectionId;
    int sourceId;
    int actuatorId;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "service")
    Plan plan;
    
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
