/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.services.Impl;

import com.sibu.flightsystemweb.domain.Ticket;
import com.sibu.flightsystemweb.repository.TicketRepository;
import com.sibu.flightsystemweb.services.EnquiryService;
import com.sibu.flightsystemweb.services.PrintTicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author stud
 */
public class PrintTicketServiceImpl implements PrintTicketService{

    @Autowired
    private TicketRepository ticRep;
    private EnquiryService flySer;
    
    
    
    @Override
    public String print() {
    
        return ticRep.toString();
        
    
    }
    
    
    
}
