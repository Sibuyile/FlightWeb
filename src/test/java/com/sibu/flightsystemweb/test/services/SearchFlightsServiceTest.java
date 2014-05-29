/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.services;

import com.sibu.flightsystemweb.app.conf.ConnectionConfig;
import com.sibu.flightsystemweb.domain.Flights;
import com.sibu.flightsystemweb.repository.FlightsRepository;
import com.sibu.flightsystemweb.services.SearchFlightService;
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
public class SearchFlightsServiceTest {
    
    private static ApplicationContext ctx;
    private FlightsRepository flyRep;
    private SearchFlightService flySer;
    private Long id;
    
    
    public SearchFlightsServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    // public void hello() {}
     public void creatSearchFlight()
     {
         flyRep = ctx.getBean(FlightsRepository.class);
         flySer = ctx.getBean(SearchFlightService.class);
         
         Flights f = new Flights.Builder("100F")
               // .canFlyt(new CancelledFlight.Builder("100F").build())
                 .className("economy")
                .flightName("SAA")
                .departureCity("Cape Town")
                .arriveCity("Durban")
                .totalCapacity("300")
                .seatsAvailable("100")
                .build();
         flyRep.save(f);
         id = f.getId();
           
          
          List <Flights> pas = flySer.searchFlights("101F");
         Assert.assertNotEquals(pas.equals(f), "100F");
     
     }
     
     @Test(dependsOnMethods = "creatSearchFlight")
     public void readSearchFlight()
     {
         flyRep = ctx.getBean(FlightsRepository.class);
         Flights f = flyRep.findOne(id);
         Assert.assertEquals(f.getClassName(), "economy");
         
         
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
