/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roipipelinecalc.imp;

import com.roipipelinecalc.dto.RouteDTO;
import javax.ejb.Local;

/**
 *
 * @author NICO_CUARTO
 */
@Local
public interface CalcBeanLocal {
    RouteDTO getRouteSupply();
}
