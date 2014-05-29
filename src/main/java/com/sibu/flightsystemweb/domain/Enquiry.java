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
public class Enquiry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String enquiryID;
    private String e_TicNum;
    private String e_FlyID;
    private String e_FlyName;
    private String e_TravelDate;
    private String e_SeatsAvailable;
    
    private Enquiry () {
    }
    
    private Enquiry(Builder builder)
    {
        id = builder.id;
        e_TicNum = builder.e_TicNum;
        e_FlyID = builder.e_FlyID;
        e_FlyName = builder.e_FlyName;
        e_TravelDate = builder.e_TravelDate;
        e_SeatsAvailable = builder.e_SeatsAvailable;
        enquiryID = builder.enquiryID;
        
    }

    
    public static class Builder {
        private Long id;
        private String e_TicNum;
        private String e_FlyID;
        private String e_FlyName;
        private String e_TravelDate;
        private String e_SeatsAvailable;
        private String enquiryID;
        
        
       
         public Builder(String flightID) {
            this.enquiryID = flightID;
        }
         
         public Builder id(Long value) {
            id = value;
            return this;
        }

        
        public Builder()
        {
            
        }
        
        public Builder e_FlyName(String name)
        {
            e_FlyName = name;
            return this;
        }
        
        public Builder e_TicNum(String tNum)
        {
            e_TicNum = tNum;
            return this;
        }
        
        public Builder e_FlyID(String fID)
        {
            e_FlyID = fID;
            return this;
        }
        
        public Builder e_TravelDate(String tDate)
        {
            e_TravelDate = tDate;
            return this;
        }
        
        public Builder e_SeatsAvailable(String seatsAv)
        {
            e_SeatsAvailable = seatsAv;
            return this;
        }
        
         public Builder enquiryID(String eID)
        {
            enquiryID = eID;
            return this;
        }
     
        public Builder flight(Flights f)
        {
            id = f.getId();
            e_FlyName = f.getFlightName();
            e_TicNum = f.getArriveCity();
            e_FlyID = f.getDepartureCity();
            e_TravelDate = f.getTotalCapacity();
            e_SeatsAvailable = f.getSeatsAvailable();
            enquiryID = f.getClassName();
    
            return this;
             
        }


        public Enquiry build()
        {
           return new Enquiry(this);
            
        }
    
    }
    

    public String getE_TicNum() {
        return e_TicNum;
    }

    public String getE_FlyID() {
        return e_FlyID;
    }

    public String getE_FlyName() {
        return e_FlyName;
    }

   /* public String getE_PassID() {
        return e_PassID;
    }
*/
    public String getE_TravelDate() {
        return e_TravelDate;
    }

    public String getE_SeatsAvailable() {
        return e_SeatsAvailable;
    }

    public String getEnquiryID() {
        return enquiryID;
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
        if (!(object instanceof Enquiry)) {
            return false;
        }
        Enquiry other = (Enquiry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sibu.flightsystemweb.domain.Enquiry[ id=" + id + " ]";
    }
    
}
