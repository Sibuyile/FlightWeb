/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.repository;

import com.sibu.flightsystemweb.app.conf.ConnectionConfig;
import com.sibu.flightsystemweb.domain.CancelledFlight;
import com.sibu.flightsystemweb.domain.Flights;
import com.sibu.flightsystemweb.repository.FlightsRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author stud
 */
public class FlightsRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private FlightsRepository flyRepo;
    private static CancelledFlight canFly;
   // List <CancelledFlight> c = new ArrayList<>();
   
    public FlightsRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void cancelFlight()
    {
        flyRepo = ctx.getBean(FlightsRepository.class);
        Flights f = new Flights.Builder("100F")
                .canFlyt(new CancelledFlight.Builder("100F").build())
                .flightName("SAA")
                .departureCity("Cape Town")
                .arriveCity("Durban")
                .totalCapacity("300")
                .seatsAvailable("100")
                .build();
        flyRepo.save(f);
        id = f.getId();
        Assert.assertSame(f.getFlightID(), canFly.getCancelFlightID());
        
        
    }
    
    
  /*  @Test
    public void creatFlights()
    {
        
        
        flyRepo = ctx.getBean(FlightsRepository.class);
        Flights f = new Flights.Builder("101F")
                .canFlyt(new CancelledFlight.Builder("101F")
               
                        .build())
                .build();
        flyRepo.save(f);
        id = f.getId();
        Assert.assertEquals(f.getFlightID(), canFly.getCancelFlightID());
    }
    */
    @Test(dependsOnMethods = "cancelFlight")
    public void readFlights()
    {
        
        flyRepo = ctx.getBean(FlightsRepository.class);
        Flights f = flyRepo.findOne(id);
        Assert.assertEquals(f.getFlightName(), "SAA");
        
    }
    
    @Test(dependsOnMethods = "readFlights")
    private void updateFlights()
    {
        flyRepo = ctx.getBean(FlightsRepository.class);
        Flights f = flyRepo.findOne(id);
        Flights updatedFlight = new Flights.Builder("100F")
                .flight(f)
                .flightName("Mango")
                .build();
        flyRepo.save(updatedFlight);
        Flights newFlight = flyRepo.findOne(id);
        Assert.assertEquals(newFlight.getFlightName(), "Mango");
        
    }
    /* 
       //  Assert.fail(c.getCell());
        
        // List <Club> cls = new ArrayList<Club>();
         
        // cls.add((Club) cl);
        //  Assert.assertEquals(cl, cls);
      //   cls.add("nobu");
         
     
     }
     */
 
     @Test(dependsOnMethods = "updateFlights")
     private void deleteFlights(){
         
         flyRepo = ctx.getBean(FlightsRepository.class);
         Flights f = flyRepo.findOne(id);
         flyRepo.delete(f);
         
         Flights deletedFlights = flyRepo.findOne(id);
         
         Assert.assertNull(deletedFlights);
            
     }
    
    

    @BeforeClass
    public void setUpClass() throws Exception {
        
         ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
         canFly = new CancelledFlight.Builder("100F").build();
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

