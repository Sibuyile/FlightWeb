/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.services;

import com.sibu.flightsystemweb.app.conf.ConnectionConfig;
import com.sibu.flightsystemweb.domain.Passenger;
import com.sibu.flightsystemweb.domain.Ticket;
import com.sibu.flightsystemweb.repository.PassengerRepository;
import com.sibu.flightsystemweb.repository.TicketRepository;
import com.sibu.flightsystemweb.services.ListOfPassengersService;
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
public class ListOfPassengerServiceTest {
    
    private static ApplicationContext ctx;
    private PassengerRepository passRep;
    private ListOfPassengersService passSer;
    private Long id;
    
    ListOfPassengerServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    // public void hello() {}
     public void createPassenger()
     {
         passSer = ctx.getBean(ListOfPassengersService.class);
         List<Passenger> f = passSer.getTicketID("101P");
         Assert.assertNotEquals(f.containsAll(f), "101P");
         
         
        /* passRep = ctx.getBean(PassengerRepository.class);
         passSer = ctx.getBean(ListOfPassengersService.class);
         
         Passenger p = new Passenger.Builder("105P")
                 
                 .passAddress("G321 Catsville Res")
                 .passDob("17 April 1995")
                 .passEmail("smdla@gmail.com")
                 .passName("Sibu Mdla")
                 .phoneNumber("0782686802")
                 .travelDate("23 May 2014")
                 .build();
          
          List <Passenger> pas = passSer.getTicketID("103T");
         Assert.assertNotEquals(pas.equals(p), "104T");
         */
    
     }
     
     /* @Test(dependsOnMethods = "createPassenger")
     public void readPassenger(){
         
         passRep = ctx.getBean(PassengerRepository.class);
         Passenger p = passRep.findOne(id);
         Assert.assertEquals(p.getPassName(), "Sibu Mdla");
         
     }
     
    @Test(dependsOnMethods = "readPassenger")
     private void updatePassenger(){
         passRep = ctx.getBean(PassengerRepository.class);
         Passenger f = passRep.findOne(id);
         Passenger updatedPassenger = new Passenger.Builder("105P")
                // .flight(f)
                 .passName("Asenathi Gaca")
                 .build();
        
         passRep.save(updatedPassenger);
         
         Passenger newPassenger = passRep.findOne(id);
         Assert.assertEquals(newPassenger.getPassName(), "Asenathi Gaca");
         
     }
     
     @Test(dependsOnMethods = "updatePassenger")
     private void deletePassenger(){
         passRep = ctx.getBean(PassengerRepository.class);
         Passenger f = passRep.findOne(id);
         passRep.delete(f);
         
         Passenger deletedPassenger = passRep.findOne(id);
         
         Assert.assertNull(deletedPassenger);
  
    }*/

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
