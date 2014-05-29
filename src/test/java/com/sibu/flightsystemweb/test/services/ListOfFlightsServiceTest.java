/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.services;

import com.sibu.flightsystemweb.app.conf.ConnectionConfig;
import com.sibu.flightsystemweb.domain.Flights;
import com.sibu.flightsystemweb.repository.FlightsRepository;
import com.sibu.flightsystemweb.services.ListOfFlightsService;
import static com.sibu.flightsystemweb.test.repository.FlightsRepositoryTest.ctx;
import java.util.ArrayList;
import java.util.List;
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
public class ListOfFlightsServiceTest {
    
    private static ApplicationContext ctx;
    private FlightsRepository flyRepo;
    private ListOfFlightsService flySer;
    private Long id;
    private String i;
    
    
    public ListOfFlightsServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    // public void hello() {}
     
     public void creatFlightsTest()
     {   
         /*
          service = ctx.getBean(TotalPeopleService.class);
         List<Person> people = service.getTotalPeople();
         
         Assert.assertEquals(0, people.size(), " Expert no People");
         
         */
         
         flySer = ctx.getBean(ListOfFlightsService.class);
         List<Flights> f = flySer.getTotalFlights();
         Assert.assertNotEquals(f.containsAll(f), "101F");
         /*
         flyRepo = ctx.getBean(FlightsRepository.class);
        
        // List<Flights> f = flySer.getTotalFlights();
         
         Flights f = new Flights.Builder("101F")
                
                 .flightName("SAA")
                .departureCity("Cape Town")
                .arriveCity("Durban")
                .totalCapacity("300")
                .seatsAvailable("100")
                 .build();
         id = f.getId();
         flyRepo.save(f);
         
         List <Flights> fly = flySer.getTotalFlights();
         
         Assert.assertEquals(fly.equals(f), "101F");
           */
     }
    
    /* @Test(dependsOnMethods = "creatFlightsTest")
     public void readListOfFlights(){
         
         flyRepo = ctx.getBean(FlightsRepository.class);
        Flights f = flyRepo.findOne(id);
        
        
        
               // List<Account> accounts = person.getAccounts();

        //for (Account account : accounts) {
       //     System.out.println(" The Account Name is " + account.getName() + " The Balance is " + account.getBalance());        
        
        
      //  List <Flights> fly = f.;
        
    //    for(Flights fly: fl)
        
         Assert.assertEquals(f.getFlightName(), "SAA");
         
     }
     
     
    @Test(dependsOnMethods = "readListOfFlights", enabled = true)
     private void updateFlights(){
         
         flyRepo = ctx.getBean(FlightsRepository.class);
         Flights f = flyRepo.findOne(id);
         Flights updatedFlights = new Flights.Builder("101F")
                 .flight(f)
                 .flightName("British Airways")
                 .build();
        
         flyRepo.save(updatedFlights);
         
         Flights newFlights = flyRepo.findOne(id);
         Assert.assertEquals(newFlights.getFlightName(), "British Airways");
         
     }
     
     @Test(dependsOnMethods = "updateFlights")
     private void deleteFlights(){
         flyRepo = ctx.getBean(FlightsRepository.class);
         Flights f = flyRepo.findOne(id);
         flyRepo.delete(f);
         
         Flights deletedFlights = flyRepo.findOne(id);
         
         Assert.assertNull(deletedFlights);
         
         
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
