/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.services;

import com.sibu.flightsystemweb.domain.Flights;
import java.util.List;

/**
 *
 * @author stud
 */
public interface SearchFlightService {
    
    public List <Flights> searchFlights(String id);
    
}
