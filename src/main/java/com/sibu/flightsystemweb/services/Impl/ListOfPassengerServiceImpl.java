/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.services.Impl;

import com.sibu.flightsystemweb.domain.Flights;
import com.sibu.flightsystemweb.domain.Passenger;
import com.sibu.flightsystemweb.domain.Ticket;
import com.sibu.flightsystemweb.repository.FlightsRepository;
import com.sibu.flightsystemweb.repository.PassengerRepository;
import com.sibu.flightsystemweb.repository.TicketRepository;
import com.sibu.flightsystemweb.services.ListOfFlightsService;
import com.sibu.flightsystemweb.services.ListOfPassengersService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stud
 */
@Service
public class ListOfPassengerServiceImpl implements ListOfPassengersService{
    
    @Autowired
    private PassengerRepository  pasRep;
    

    @Override
    public List<Passenger> getTicketID(String passID) {
        
        
        return pasRep.findAll();
        
        /*
        List <Passenger> pas = new ArrayList<>();
        List <Passenger> allPas = pasRep.findAll();
        
        for(Passenger p : allPas)
        {
            if(p.getPassengerID().equals(allPas))
            {
                pas.add(p);
            }
            
        }
        
        return pas;
        */
    }

   /* @Override
    public List<Passenger> getTicketID(String passID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
}
