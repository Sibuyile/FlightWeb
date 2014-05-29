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
public class Pilot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     private String name;
    private String email;
    private String phoneNo;
    private String address;
    private String dob;
    private String pilotID;

    
    private Pilot () {
    }
    
    private Pilot(Builder builder)
    {
        id = builder.id;
        name = builder.name;
        email = builder.email;
        phoneNo = builder.phoneNo;
        address = builder.address;
        dob = builder.dob;
        pilotID = builder.pilotID;
      
        
    }
    
    
    public static class Builder {
        private Long id;
        private String name;
        private String email;
        private String phoneNo;
        private String address;
        private String dob;
        private String pilotID;
        
     

        public Builder(String pID) {
            
            this.pilotID = pID;
  
        }
        
        public Builder()
        {
            
        }
        
        public Builder id(Long ID)
        {
            id = ID;
            return this;
        }
        
        public Builder fAttEmail(String em)
        {
            email = em;
            return this;
        }
        
        public Builder name(String pn)
        {
            name = pn;
            return this;
        }
        
        public Builder phoneNo(String fno)
        {
            phoneNo = fno;
            return this;
        }
        
        public Builder address(String add)
        {
            address = add;
            return this;
        }
        
        public Builder dob(String dOb)
        {
            dob = dOb;
            return this;
        }
      
        
        
        public Builder Pilot(Pilot p)
        {
            id = p.getId();
            name = p.getName();
            email = p.getEmail();
            phoneNo = p.getPhoneNo();
            address = p.getDob();
            dob = p.getDob();
            pilotID = p.pilotID;
            
            return this;
             
        }
        
        public Pilot build()
        {
           return new Pilot(this);
            
        }
        
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public Long getId() {
        return id;
    }
    
    public String getPilotID() {
        return pilotID;
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
        if (!(object instanceof Pilot)) {
            return false;
        }
        Pilot other = (Pilot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sibu.flightsystemweb.domain.Pilot[ id=" + id + " ]";
    }
    
}
