/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.services.Impl;

import com.sibu.flightsystemweb.domain.Enquiry;
import com.sibu.flightsystemweb.domain.Flights;
import com.sibu.flightsystemweb.domain.Ticket;
import com.sibu.flightsystemweb.repository.FlightsRepository;
import com.sibu.flightsystemweb.repository.TicketRepository;
import com.sibu.flightsystemweb.services.EnquiryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stud
 */
@Service
public class EnquiryServiceImpl implements EnquiryService{
    
    @Autowired
    private FlightsRepository flyRep;
    private TicketRepository ticRep;
    private Ticket tic;

    @Override
    public List<Flights> getFlightID(String fiD) {
        
         
        List <Flights> fly = new ArrayList<>();
        List <Flights> allFly = flyRep.findAll();
        
        for(Flights f : allFly)
        {
            if(f.getFlightID().equals(tic.getTicketID()) )
            {
                fly.add(f);
            }
            
        }
        
        return fly;
        
    }

  
    @Override
    public Object merge(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object persist(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
          
}
