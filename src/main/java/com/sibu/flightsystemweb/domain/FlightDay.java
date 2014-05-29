/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author stud
 */
@Entity
public class FlightDay implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     private String flightDaysID;
    private String departureDate;
   /* @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "flights_id")
     private Flights flyDays;
   */
    
     private FlightDay () {
    }
    
    private FlightDay(Builder builder)
    {
        flightDaysID = builder.flightDaysID;
        departureDate = builder.departureDate;
        
    }

     public static class Builder {
         
        private String flightDaysID;
        private String departureDate;
       

        public Builder(String id) {
            
            this.flightDaysID = id;
        }
        
         public Builder()
         {
  
         }

        public Builder Date(String dt)
        {
            departureDate = dt;
            return this;
        }
        

        public Builder flightDays(FlightDay fd)
        {
            flightDaysID = fd.getFlightDaysID();
            departureDate = fd.getDate();
           
            
            return this;
            
        }
        
        public FlightDay build()
        {
            return new FlightDay(this);
        }
    }

    
     public String getFlightDaysID() {
            return flightDaysID;
        }

        public String getDate() {
            return departureDate;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FlightDay)) {
            return false;
        }
        FlightDay other = (FlightDay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sibu.flightsystemweb.domain.FlightDays[ id=" + id + " ]";
    }
    
}
