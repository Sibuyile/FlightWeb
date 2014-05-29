/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.presentation.rest;

import com.sibu.flightsystemweb.domain.Flights;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author stud
 */
@Controller
@RequestMapping(value = "api/flights")
public class ListOfFlightsRestController {
    
    @RequestMapping(value = "create")
    @ResponseBody
    public String create(@RequestBody Flights f) {
        System.out.println(" Create the Called ");
        return "";
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(@RequestBody Flights person) {
        System.out.println(" Update Called ");
        return "";
    }

    @RequestMapping(value = "flights/{id}")
    @ResponseBody
    public Flights getFlights(@PathVariable String id) {
        System.out.println(" ID called ");
        return null;
    }

    @RequestMapping(value = "clubs")
    @ResponseBody
    public List<Flights> getFlights() {
        System.out.println("The flights");
        return null;
    }

    @RequestMapping(value = "flights/{name}")
    @ResponseBody
    public Flights getFlightName(@PathVariable String id) {
        System.out.println("The Flights name");
        return null;
    }

}
