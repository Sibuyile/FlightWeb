/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author stud
 */
@Entity
public class FlightAttendant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     private String fAttName;
    private String fAttEmail;
    private String fAttPhoneNo;
    private String fAttAddress;
    private String fAttDob;
    private String flightAttendantID;
    
    
    private FlightAttendant () {
    }
    
    private FlightAttendant(Builder builder)
    {
        id = builder.id;
        fAttName = builder.fAttName;
        fAttEmail = builder.fAttEmail;
        fAttPhoneNo = builder.fAttPhoneNo;
        fAttAddress = builder.fAttAddress;
        fAttDob = builder.fAttDob;
        flightAttendantID = builder.flightAttendantID;
      
        
    }
    
    
    public static class Builder {
        private Long id;
        private String fAttName;
        private String fAttEmail;
        private String fAttPhoneNo;
        private String fAttAddress;
        private String fAttDob;
        private String flightAttendantID;
        
     

        public Builder(String fID) {
            
            this.flightAttendantID = fID;
  
        }
        
        public Builder()
        {
            
        }
        
        public Builder id(Long id)
        {
            id = id;
            return this;
        }
        
        public Builder fAttEmail(String e)
        {
            fAttEmail = e;
            return this;
        }
        
        public Builder fAttName(String pn)
        {
            fAttName = pn;
            return this;
        }
        
        public Builder fAttPhoneNo(String fno)
        {
            fAttPhoneNo = fno;
            return this;
        }
        
        public Builder fAttAddress(String add)
        {
            fAttAddress = add;
            return this;
        }
        
        public Builder fAttDob(String dOb)
        {
            fAttDob = dOb;
            return this;
        }
      
        
        
        public Builder FlightAttendant(FlightAttendant p)
        {
            id = p.getId();
            fAttName = p.getName();
            fAttEmail = p.getEmail();
            fAttPhoneNo = p.getPhoneNo();
            fAttAddress = p.getDob();
            fAttDob = p.getDob();
            flightAttendantID = p.flightAttendantID;
            
            return this;
             
        }
        
        public FlightAttendant build()
        {
           return new FlightAttendant(this);
            
        }
        
    }

    public String getName() {
        return fAttName;
    }

    public String getEmail() {
        return fAttEmail;
    }

    public String getPhoneNo() {
        return fAttPhoneNo;
    }

    public String getAddress() {
        return fAttAddress;
    }

    public String getDob() {
        return fAttDob;
    }

    public Long getId() {
        return id;
    }
    
     public String getFlightAttendantID() {
            return flightAttendantID;
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
        if (!(object instanceof FlightAttendant)) {
            return false;
        }
        FlightAttendant other = (FlightAttendant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sibu.flightsystemweb.domain.FlightAttendant[ id=" + id + " ]";
    }
    
}