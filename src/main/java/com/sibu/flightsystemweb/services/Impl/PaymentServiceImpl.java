/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.services.Impl;

import com.sibu.flightsystemweb.domain.Payment;
import com.sibu.flightsystemweb.domain.Status;
import com.sibu.flightsystemweb.repository.PaymentRepository;
import com.sibu.flightsystemweb.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stud
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    
    @Autowired
    private PaymentRepository payRepo;
    private Status st;
    //private double flightCost;
    private Payment p;

    @Override
    public Double payment(Double pay) {

        
         if(st.getStatusName().equals("Economy"))
         {
            
            pay = p.getNoOfPassengers() * st.getAmount();
         }
         else if
                (st.getStatusName().equals("Business"))
                {
                       pay = p.getNoOfPassengers() * 1500.0;
                }
         else if
                 (st.getStatusName().equals("First class"))
                 {
                        pay = p.getNoOfPassengers() * 2500.0;
                 }
         
        return pay;
         
        
        
    
    }
    
    
    
}
