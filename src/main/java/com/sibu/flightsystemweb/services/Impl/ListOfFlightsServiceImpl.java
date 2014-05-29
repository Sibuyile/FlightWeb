/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.services.Impl;

import com.sibu.flightsystemweb.domain.Flights;
import com.sibu.flightsystemweb.repository.FlightsRepository;
import com.sibu.flightsystemweb.services.ListOfFlightsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stud
 */
@Service
public class ListOfFlightsServiceImpl implements ListOfFlightsService{
    
    @Autowired
    private FlightsRepository  flyRep;
    

    @Override
    public List<Flights> getTotalFlights() {
    
        List <Flights> f = flyRep.findAll();
        return f;
        
        
    }
    
}
