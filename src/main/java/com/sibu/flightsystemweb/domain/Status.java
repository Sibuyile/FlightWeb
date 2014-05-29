/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author stud
 */
@Embeddable
public class Status implements Serializable{
    
     
    private String statusID;
    private String statusName;
    private Double amount;
  
    
     private Status () {
    
     }
    
    
    private Status(Builder builder)
    {
        statusID = builder.statusID;
        statusName = builder.statusName;
        amount = builder.amount;
    
        
    }

    public static class Builder {
        private String statusID;
        private String statusName;
        private Double amount;
   

        public Builder(String id) {
            
            this.statusID = id;
        }
        
         public Builder()
         {
    
         }
        
        public Builder Name(String name)
        {
            statusName = name;
            return this;
        }
        
        public Builder Amount(Double amt)
        {
            amount = amt;
            return this;
        }

      
        public Builder status(Status s)
        {
            statusID = s.getStatusID();
            statusName = s.getStatusName();
            amount = s.getAmount();
       
            
            return this;
            
        }
        
        public Status build()
        {
            return new Status(this);
            
        }

    }
    

    public String getStatusID() {
        return statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public Double getAmount() {
        return amount;
    }
    
}
