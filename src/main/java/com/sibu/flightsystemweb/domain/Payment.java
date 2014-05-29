/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
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
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String paymentID;
    private Double paidAmount;
    private String paymentDate;
    private String bookingVenue;
     
   // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "payment_id")
    
    private Flights fID;
    private int noOfPassengers;
   
    
   
     private Payment()
    {
        
        
    }
    
    private Payment(Builder builder)
    {
        paymentID = builder.paymentID;
        paidAmount = builder.paidAmount;
        paymentDate = builder.paymentDate;
        bookingVenue = builder.bookingVenue;
        fID = builder.fID;
    
        noOfPassengers = builder.noOfPassengers;
        
    }

    public static class Builder {
        private String paymentID;
        private Double paidAmount;
        private String paymentDate;
        private String bookingVenue;
        private Flights fID;
    
        private int noOfPassengers;

        public Builder(String id) {
            
            this.paymentID = id;
            
        }
        
         public Builder()
         {
             
             
             
         }
        
        public Builder paidAmount(Double pa)
        {
            paidAmount = pa;
            return this;
            
        }
        
        public Builder paymentDate(String pd)
        {
            paymentDate = pd;
            return this;
            
        }
        
        public Builder bookingVenue(String bv)
        {
            bookingVenue = bv;
            return this;
            
        }
         
        public Builder fID(Flights fI)
        {
            fID = fI;
            return this;
            
        }
        
        
        public Builder numPass(int np)
        {
            noOfPassengers = np;
            return this;
            
        }
        
        public Builder payment(Payment pm)
        {
            paymentID = pm.getPaymentID();
            paidAmount = pm.getPaidAmount();
            paymentDate = pm.getPaymentDate();
            bookingVenue = pm.getBookingVenue();
            fID = pm.getfID();
    
            noOfPassengers = pm.getNoOfPassengers();
        //    r.getReservationID();
            
            return this;
        }
        
        public Payment build()
        {
            
            return new Payment(this);
        }
    }

    public String getPaymentID() {
        return paymentID;
    }

    

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getBookingVenue() {
        return bookingVenue;
    }

    public Flights getfID() {
        return fID;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
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
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sibu.flightsystemweb.domain.Payment[ id=" + id + " ]";
    }
    
}
