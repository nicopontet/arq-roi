/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roipipelinecalc.dto;

import java.util.List;

/**
 *
 * @author NICO_CUARTO
 */
public class RouteDTO {
   List<RouteNodeDTO> route;

    public RouteDTO() {
    }

    public RouteDTO(List<RouteNodeDTO> route) {
        this.route = route;
    }

    public List<RouteNodeDTO> getRoute() {
        return route;
    }

    public void setRoute(List<RouteNodeDTO> route) {
        this.route = route;
    }
   
}

