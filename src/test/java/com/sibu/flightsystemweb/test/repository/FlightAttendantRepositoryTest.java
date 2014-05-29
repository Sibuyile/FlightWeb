/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.repository;

import com.sibu.flightsystemweb.app.conf.ConnectionConfig;
import com.sibu.flightsystemweb.domain.FlightAttendant;
import com.sibu.flightsystemweb.repository.FlightAttendantRepository;
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
public class FlightAttendantRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;

  private FlightAttendantRepository flyRep;
    
    
    public FlightAttendantRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     
    @Test
     public void createHost()
     {
         flyRep = ctx.getBean(FlightAttendantRepository.class);
     
         FlightAttendant fa = new FlightAttendant.Builder("100A")
                 .fAttName("Sibuyile")
                 .fAttDob("17 April 1991")
                 .fAttAddress("52 Swalllow Drive")
                 .fAttEmail("sibum0341@gmail.com")
                 .fAttPhoneNo("0782686802")   
                 .build();
         flyRep.save(fa);
         id = fa.getId();
        Assert.assertNotNull(fa);         
     }
     
     @Test(dependsOnMethods = "createHost")
     public void readHost()
     {
         
         flyRep = ctx.getBean(FlightAttendantRepository.class);
         FlightAttendant fa = flyRep.findOne(id);
         Assert.assertEquals(fa.getAddress(), "52 Swalllow Drive");
         
         
         
     }
     
    @Test(dependsOnMethods = "readHost")
     private void updateHost(){
         
         flyRep = ctx.getBean(FlightAttendantRepository.class);
         FlightAttendant fa = flyRep.findOne(id);
         FlightAttendant updatedFAtt = new FlightAttendant.Builder("100A")
                 .FlightAttendant(fa)
                 .fAttAddress("29 Maluti Street")
                 .build();
        
         flyRep.save(updatedFAtt);
         
         FlightAttendant newPilot = flyRep.findOne(id);
         Assert.assertEquals(newPilot.getAddress(), "29 Maluti Street");
         
     }
     
    
     @Test(dependsOnMethods = "updateHost")
     private void deletePilot(){
         flyRep = ctx.getBean(FlightAttendantRepository.class);
         FlightAttendant pilot = flyRep.findOne(id);
         flyRep.delete(pilot);
         
         FlightAttendant deletedPilot = flyRep.findOne(id);
         
         Assert.assertNull(deletedPilot);
         
     }
     

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
    