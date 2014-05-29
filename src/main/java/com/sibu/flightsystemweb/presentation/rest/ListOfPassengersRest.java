/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.presentation.rest;

import com.sibu.flightsystemweb.domain.Passenger;
import com.sibu.flightsystemweb.domain.Passenger;
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
@RequestMapping(value = "api/passengers")
public class ListOfPassengersRest {
    
    @RequestMapping(value = "create")
    @ResponseBody
    public String create(@RequestBody Passenger p) {
        System.out.println(" Create the Called ");
        return "";
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(@RequestBody Passenger p) {
        System.out.println(" Update Called ");
        return "";
    }

    @RequestMapping(value = "passenger/{id}")
    @ResponseBody
    public Passenger getPassenger(@PathVariable String id) {
        System.out.println(" ID called ");
        return null;
    }

    @RequestMapping(value = "clubs")
    @ResponseBody
    public List<Passenger> getPassenger() {
        System.out.println("The flights");
        return null;
    }

    @RequestMapping(value = "passenger/{name}")
    @ResponseBody
    public Passenger getPassengerName(@PathVariable String id) {
        System.out.println("The Passenger name");
        return null;
    }

}
