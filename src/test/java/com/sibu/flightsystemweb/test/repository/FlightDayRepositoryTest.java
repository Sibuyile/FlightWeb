/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.repository;

import com.sibu.flightsystemweb.app.conf.ConnectionConfig;
import com.sibu.flightsystemweb.domain.FlightDay;
import com.sibu.flightsystemweb.domain.Flights;
import com.sibu.flightsystemweb.repository.FlightDayRepository;
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
public class FlightDayRepositoryTest {
    
    private static ApplicationContext ctx;
    private FlightDayRepository flyDaysRepo;
    private Long id;
    
    
    public FlightDayRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    // public void hello() {}
     public void flightDaysTest()
     {
         flyDaysRepo = ctx.getBean(FlightDayRepository.class);
         
        Flights fd = new Flights.Builder("101F")
                .flightName("SAA")
                .departureCity("Jhb")
                .arriveCity("CPT")
                .flyDays(new FlightDay.Builder("101FD")
                        .Date("29 May 2014")
                        .flightDays(null)
                        .build())
                .build();
         
                  
         
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
