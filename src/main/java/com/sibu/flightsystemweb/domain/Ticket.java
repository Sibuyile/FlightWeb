
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.domain;

import java.io.Serializable;
import java.util.List;
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
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String ticketID;
    private String ticketNumber;

   // private String className;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_id")
    private List <Passenger> pass;
    private Flights fly;

    
     private Ticket () {
     }
    
    private Ticket(Builder builder)
    {
        id = builder.id;
        ticketNumber = builder.ticketNumber;
        ticketID = builder.ticketID;
        pass = builder.pass;
     
        fly = builder.fly;
             
    }
    
    
    public static class Builder {
        private Long id;
     
        private String ticketNumber;
        private String ticketID;
        private List <Passenger> pass;
        private Flights fly;
      
  

        public Builder(String ticID) {
            
            this.ticketID = ticID;
  
        }
        
        
        
        public Builder()
        {
            
        }
        
        public Builder id(Long i)
        {
            id = i;
            return this;
        }
        
        public Builder ticketNumber(String tn)
        {
            ticketNumber = tn;
            return this;
        }
        
        public Builder pass(List <Passenger> p)
        {
            pass = p;
            return this;
        }
        
         public Builder fly(Flights f)
        {
            fly = f;
            return this;
        }
         
     
        public Builder ticket(Ticket t)
        {
           id = t.getId();
           ticketNumber = t.getTicketNumber();
           ticketID = t.getTicketID();
           pass = t.getPass();

           
          
            return this;
             
        }
        
        public Ticket build()
        {
           return new Ticket(this);
            
        }
        
    }
    
    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getTicketID() {
        return ticketID;
    }

    public List <Passenger> getPass() {
        return pass;
    }

    public Flights getFly() {
        return fly;
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
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sibu.flightsystemweb.domain.Ticket[ id=" + id + " ]";
    }
    
}