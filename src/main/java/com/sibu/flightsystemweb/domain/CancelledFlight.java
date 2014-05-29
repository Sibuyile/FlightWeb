/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author stud
 */
//@Entity
@Embeddable
public class CancelledFlight implements Serializable {
   /* private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    */
   
    private String c_flightID;
   // @Column(unique = true)
    private String cancelFlightID;
    
    
    
     private CancelledFlight()
     {
         
     }
     
     private CancelledFlight(Builder builder)
     {
         cancelFlightID = builder.cancelFlightID;
       
         c_flightID = builder.c_flightID;
 
     }
     
    public static class Builder {
       
        private String cancelFlightID;
       
        private String c_flightID;
     

         public Builder()
         {
                
         }

        public Builder(String flyID) {
            
             this.cancelFlightID = flyID;
            
        } 
        
        
        public Builder c_flightID(String fID)
        {
            c_flightID = fID;
            return this;
        }
        
        
        public Builder cancelFlight(CancelledFlight cf)
        {
            cancelFlightID = cf.getCancelFlightID();
           
            c_flightID = cf.getFlightID();
   
            return this;
            
        }
        
         
        public CancelledFlight build()
        {
            return new CancelledFlight(this);
        }
   
    }

    public String getCancelFlightID() {
        return cancelFlightID;
    }

  

    public String getFlightID() {
        return c_flightID;
    }
  /* 
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
        if (!(object instanceof CancelledFlight)) {
            return false;
        }
        CancelledFlight other = (CancelledFlight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sibu.flightsystemweb.domain.CancelledFlight[ id=" + id + " ]";
    }
    */
    
}
