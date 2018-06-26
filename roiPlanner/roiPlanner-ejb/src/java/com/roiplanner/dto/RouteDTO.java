/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roiplanner.dto;

import java.util.List;

/**
 *
 * @author NICO_CUARTO
 */
public class RouteDTO {
   List<RouteNodeDTO> sections;

    public RouteDTO() {
    }

    public RouteDTO(List<RouteNodeDTO> route) {
        this.sections = route;
    }

    public List<RouteNodeDTO> getRoute() {
        return sections;
    }

    public void setRoute(List<RouteNodeDTO> route) {
        this.sections = route;
    }
   
}

