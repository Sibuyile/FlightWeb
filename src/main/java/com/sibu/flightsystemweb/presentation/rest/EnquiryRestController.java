/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.presentation.rest;

import com.sibu.flightsystemweb.domain.Enquiry;
import com.sibu.flightsystemweb.services.EnquiryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author stud
 */
@Controller
@RequestMapping(value = "api/enquiry")
public class EnquiryRestController {
    
    @Autowired
    private EnquiryService enquiryService;
    
    @RequestMapping(value = "create",method = RequestMethod.POST) // This the uri e.g http://localhost:8084/askweb/api/club/create
    @ResponseBody
    public String create(@RequestBody Enquiry enq)
    {
        enquiryService.persist(enq);
        
        System.out.println("Creating enquiry");
        return "Enquiry Created";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT) //This the uri e.g http://localhost:8084/askweb/api/club/update
    @ResponseBody
    public String update(@RequestBody Enquiry enq) {
        enquiryService.merge(enq);
        System.out.println(" Update Called ");
        return "Enquiry Update";
    }

   /* @RequestMapping(value = "id/{id}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/club/1234
    @ResponseBody
    public Enquiry getClub(@PathVariable Long id) { //@PathVariable used to bind the id value
        
        System.out.println(" ID called ");
        return enquiryService.find(id);
    }
    */

    @RequestMapping(value = "enquiry",method = RequestMethod.GET) // Always Put HTTP Method
    @ResponseBody
    public List<Enquiry> getEnquiry() {
        System.out.println("The Enquriy");
        return enquiryService.findAll();
    }

   /* @RequestMapping(value = "name/{name}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/club/football
    @ResponseBody
    public Enquiry getEnquiry(@PathVariable String name) {
        Enquiry enq = enquiryService.getFlightID(name); // Call the Service;
        if(enq!=null){
            return enq;
        }
        return null;
    }
    */
    
}
