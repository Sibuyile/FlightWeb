/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.services;

import com.sibu.flightsystemweb.app.conf.ConnectionConfig;
import com.sibu.flightsystemweb.domain.Flights;
import com.sibu.flightsystemweb.domain.Payment;
import com.sibu.flightsystemweb.domain.Status;
import com.sibu.flightsystemweb.repository.FlightsRepository;
import com.sibu.flightsystemweb.repository.PaymentRepository;
import com.sibu.flightsystemweb.services.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;
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
public class PaymentServiceTest {
    
    private static ApplicationContext ctx;
    private PaymentRepository payRepo;
    private PaymentService paySer;
    private Status s;
    private Flights f;
    private FlightsRepository flyRep;
    private Payment p;
    private Long id;
    
    public PaymentServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    // public void hello() {}
     public void paymentTest()
     {
         
         payRepo = ctx.getBean(PaymentRepository.class);
         flyRep = ctx.getBean(FlightsRepository.class);
         paySer = ctx.getBean(PaymentService.class);
         Double flightCost = 0.0;
         
         
         p = new Payment.Builder("100PM")
                 .fID(f)
                 .bookingVenue("Jhb")
                 .numPass(2)
                 .paidAmount(5000.0)
                 .paymentDate("27 May 2014")
                 
                 //.arriveCity("CPT")
                //.departureCity("Jhb")
               // .flightName("Mango")
                 
              //   .Name("Economy")
              //   .Amount(700.0)
              //   .build())
                // .build())
                 .build();
         f = new Flights.Builder("101F")
                 .arriveCity("CPT")
                 .departureCity("Jhb")
                 .flightName("Mango")
                 .s(new Status.Builder("101S")
                 .Name("Economy")
                 .Amount(700.0)
                 .build())
                 .build();
         
//         Double fl = paySer.payment(s.getAmount());    
         Assert.notNull(ctx);
         payRepo.save(p);
         flyRep.save(f);
         
         //id = p.getId();
        
        
        //Assert.notNull(p);
        // return p;
         
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
