/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.dto;

/**
 *
 * @author NICO_CUARTO
 */
public class RouteNodeDTO {
    String actuatorId;
    String sectionId;
    String sourceId;

    public RouteNodeDTO() {
    }

    public RouteNodeDTO(String actuatorId, String sectionId, String sourceId) {
        this.actuatorId = actuatorId;
        this.sectionId = sectionId;
        this.sourceId = sourceId;
    }

    public String getActuatorId() {
        return actuatorId;
    }

    public void setActuatorId(String actuatorId) {
        this.actuatorId = actuatorId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    
    
}
