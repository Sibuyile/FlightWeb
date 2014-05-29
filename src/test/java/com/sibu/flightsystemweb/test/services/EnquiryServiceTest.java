/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.services;

import com.sibu.flightsystemweb.app.conf.ConnectionConfig;
import com.sibu.flightsystemweb.domain.Flights;
import com.sibu.flightsystemweb.domain.Ticket;
import com.sibu.flightsystemweb.repository.FlightsRepository;
import com.sibu.flightsystemweb.services.ListOfFlightsService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
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
public class EnquiryServiceTest {
    
    private static ApplicationContext ctx;
    private FlightsRepository flyRep;
    private ListOfFlightsService flySer;
    private Flights f;
    private Ticket t;
    private Long id;
    
    public EnquiryServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    // public void hello() {}
     public void EnquiryTest()
     {
         flyRep = ctx.getBean(FlightsRepository.class);
         flySer = ctx.getBean(ListOfFlightsService.class);
         
         Flights f = new Flights.Builder("101F").className("Business").build();
         Flights f1 = new Flights.Builder("102F").className("Economy").build();
         Flights f2 = new Flights.Builder("103F").className("First").build();
         
         flyRep.save(f);
         flyRep.save(f1);
         flyRep.save(f2);
         
         List <Flights> fly = flySer.getTotalFlights();

        Assert.assertNotEquals(fly.contains(f), "101F");
           
     }
     
     /*@Test(dependsOnMethods = "EnquiryTest")
     public void readPassengers()
     {
         flyRep = ctx.getBean(FlightsRepository.class);
         Flights p = flyRep.findOne(id);
         Assert.assertEquals(p.getClassName(), "Sibu Mdla");
         
         
     }
     */

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
