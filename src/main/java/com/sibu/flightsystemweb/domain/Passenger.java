/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.domain;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author stud
 */
@Entity
public class Passenger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String passName;
    private String passDob;
    private String passEmail;
    private String passPhoneNo;
    private String passAddress;
    private String travelDate;

    @Column(unique = true)
    private String passengerID;
   
  
  //  private Ticket tic;
 //   @OneToMany(cascade = CascadeType.ALL)
 //   @JoinColumn(name = "passenger_id")
    
    
    private Passenger ()
    {
        
    }
    
    
    private Passenger(Builder builder)
    {
       // super();
       
        passName = builder.passName;
        passDob = builder.passDob;
        passPhoneNo = builder.passPhoneNo;
        passEmail = builder.passEmail;
        passengerID = builder.passengerID;
        passAddress = builder.passAddress;
        travelDate = builder.travelDate;
    
      // tic = builder.tic;
       
    }
    
     public static class Builder {
        private String passengerID;
        private String passName;
        private String passPhoneNo;
        private String passDob;
        private String passEmail;
        private String passAddress;
        private String travelDate;
      
       // private Ticket tic;

        public Builder(String id) {
            
            this.passengerID = id;
        }
        
         public Builder()
         {
             
             
             
         }
        
        public Builder passName(String pName)
        {
            passName = pName;
            return this;
        }
        
        public Builder phoneNumber(String pNo)
        {
            passPhoneNo = pNo;
            return this;
        }
        
        public Builder passDob(String dOb)
        {
            passDob = dOb;
            return this;    
            
        }
        
        public Builder passEmail(String email)
        {
            passEmail = email;
            return this;
        }
        
         public Builder passAddress(String add)
        {
            passAddress = add;
            return this;
        }
         
         public Builder travelDate(String tDate)
        {
            travelDate = tDate;
            return this;
        }
        
        
      /*  public Builder t(Ticket ti)
        {
            tic = ti;
            return this;
            
        }
        */
        public Builder passenger(Passenger psg)
        {
         
            passName = psg.getPassName();
            passPhoneNo = psg.getPhoneNo();
            passDob = psg.getpassDob();
            passEmail = psg.getEmailAdd();
            passengerID = psg.getPassengerID();
            passAddress = psg.getAddress();
            travelDate = psg.getTravelDate();
        
         //   tic = ps.getTic();
            
            return this;
        }
        
        public Passenger build()
        {
            return new Passenger(this);
        }

       
        
    }
    

    public Long getId() {
        return id;
    }

    public String getPassName() {
        return passName;
    }

    public String getpassDob() {
        return passDob;
    }

    public String getEmailAdd() {
        return passEmail;
    }

    public String getPhoneNo() {
        return passPhoneNo;
    }

    /* public Ticket getTic() {
    return tic;
    }
     */
    public String getAddress() {
        return passAddress;
    }

    public String getPassengerID() {
        return passengerID;
    }
    
     public String getTravelDate() {
        return travelDate;
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
        if (!(object instanceof Passenger)) {
            return false;
        }
        Passenger other = (Passenger) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sibu.flightsystemweb.domain.Passenger[ id=" + id + " ]";
    }
    
}
