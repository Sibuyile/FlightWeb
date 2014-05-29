/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.repository;

import com.sibu.flightsystemweb.app.conf.ConnectionConfig;
import com.sibu.flightsystemweb.domain.Passenger;
import com.sibu.flightsystemweb.repository.PassengerRepository;
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
public class PassengerRepositoryTest {
    
     public static ApplicationContext ctx;
    private Long id;

    private PassengerRepository passRep;
    
    
    public PassengerRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     
    // public void hello() { }
     
     
     public void createPassenger()
     {
         passRep = ctx.getBean(PassengerRepository.class);
         
         Passenger p = new Passenger.Builder("103PS")
                 
                  .passAddress("55 Swallow Drive")
                  .passDob("30 April 1985")
                 
                  .passEmail("pumlamdla@gmail.com")
                  .passName("Sese Mdla")
                  .phoneNumber("0827591234") 
                  .travelDate("22 June 2014")
                  .build();
         passRep.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
   
      //   passRep.save(p);
      //   id = p.getId();
      //   Assert.assertNotNull(p);
         
     }
     
     @Test(dependsOnMethods = "createPassenger")
     public void readPassenger()
     {
         
         passRep = ctx.getBean(PassengerRepository.class);
         Passenger p = passRep.findOne(id);
         Assert.assertEquals(p.getPhoneNo(), "0827591234");
         
     }
     
   /* @Test(dependsOnMethods = "readPassenger")
     private void updatePassenger(){
         passRep = ctx.getBean(PassengerRepository.class);
         Passenger p = passRep.findOne(id);
         Passenger updatedPassenger = new Passenger.Builder("103PS")
                 .passenger(p)
                 .passEmail("l@m.gmail.com")
                 .build();
        
         passRep.save(updatedPassenger);
         
         Passenger newPassenger = passRep.findOne(id);
         Assert.assertEquals(newPassenger.getAddress(), "l@m.gmail.com");
         
     }
    
     @Test(dependsOnMethods = "updatePassenger")
     private void deletePassenger(){
         passRep = ctx.getBean(PassengerRepository.class);
         Passenger pilot = passRep.findOne(id);
         passRep.delete(pilot);
         
         Passenger deletedPassenger = passRep.findOne(id);
         
         Assert.assertNull(deletedPassenger);
         
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
