/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.services.Impl;

import com.sibu.flightsystemweb.domain.Flights;
import com.sibu.flightsystemweb.repository.FlightsRepository;
import com.sibu.flightsystemweb.services.SearchFlightService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stud
 */
@Service
public class SearchFlightServiceImpl implements SearchFlightService{

    @Autowired
    private FlightsRepository flyRep;
    
    @Override
    public List<Flights> searchFlights(String id) {
       
         
        List <Flights> fly = new ArrayList<>();
        List <Flights> allFly = flyRep.findAll();
        
        for(Flights f : allFly)
        {
            if(f.getFlightID().equals(allFly))
            {
                fly.add(f);
            }
            
        }
        
        return fly;
        
    }
    
}
