/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.services;

import com.sibu.flightsystemweb.app.conf.ConnectionConfig;
import com.sibu.flightsystemweb.domain.Flights;
import com.sibu.flightsystemweb.domain.Ticket;
import com.sibu.flightsystemweb.repository.TicketRepository;
import com.sibu.flightsystemweb.services.PrintTicketService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author stud
 */
public class PrintTicketServiceTest {
    
    private static ApplicationContext ctx;
    private TicketRepository ticRep;
    private PrintTicketService printSer;
    private Long id;
    
    public PrintTicketServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    // public void hello() {}
     public void printTicket()
     {
         ticRep = ctx.getBean(TicketRepository.class);
       //  printSer = ctx.getBean(PrintTicketService.class);
         
         Ticket t = new Ticket.Builder("101T")
                 
                // .className("Business")
                 //.departureCity("Durban")
                 //.flightName("Mango")
                 //.build())
                 .build();
         
         ticRep.save(t);
         id = t.getId();
         
        // t.toString();
         
         System.out.println("The ticket number is:" + t.toString());
         
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
