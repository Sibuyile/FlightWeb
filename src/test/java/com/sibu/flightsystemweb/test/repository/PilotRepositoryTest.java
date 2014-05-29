/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.repository;

import com.sibu.flightsystemweb.app.conf.ConnectionConfig;
import com.sibu.flightsystemweb.domain.Pilot;
import com.sibu.flightsystemweb.repository.PilotRepository;
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
public class PilotRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;

  private PilotRepository pilotRep;
    
    
    public PilotRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     
     
  /*   public void hello() {
         
         pilotRep = ctx.getBean(PilotRepository.class);
         Pilot pil = new Pilot();
       //  pil.getName("Hello");
         pilotRep.save(pil);
         
     
     }*/
    @Test
     public void createPilot()
     {
         pilotRep = ctx.getBean(PilotRepository.class);
     
          Pilot p = new Pilot.Builder("100P").name("Sibuyile")
                  .phoneNo("0436553597")
                  .address("2636 Varha Road")
                  .dob("7 February 1990")
                  
                  .build();
         pilotRep.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
   
      //   pilotRep.save(p);
      //   id = p.getId();
      //   Assert.assertNotNull(p);
         
     }
     
     @Test(dependsOnMethods = "createPilot")
     public void readPilot()
     {
         
         pilotRep = ctx.getBean(PilotRepository.class);
         Pilot pilot = pilotRep.findOne(id);
         Assert.assertEquals(pilot.getName(), "Sibuyile");
         
     }
     
    @Test(dependsOnMethods = "readPilot")
     private void updatePilot(){
         pilotRep = ctx.getBean(PilotRepository.class);
         Pilot pilot = pilotRep.findOne(id);
         Pilot updatedPilot = new Pilot.Builder("100P")
                 .Pilot(pilot)
                 .name("Sibu")
                 .build();
        
         pilotRep.save(updatedPilot);
         
         Pilot newPilot = pilotRep.findOne(id);
         Assert.assertEquals(newPilot.getName(), "Sibu");
         
     }
     
     
    /* @Test(dependsOnMethods = "updatePilot")
     private void deletePilot(){
         pilotRep = ctx.getBean(PilotRepository.class);
         Pilot pilot = pilotRep.findOne(id);
         pilotRep.delete(pilot);
         
         Pilot deletedPilot = pilotRep.findOne(id);
         
         Assert.assertNull(deletedPilot);
         
     }*/
     

    @BeforeClass
    public static void setUpClass() throws Exception {
        
         ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
         //flightCapacity = new FlightCapcity.Builder("101").build();
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
