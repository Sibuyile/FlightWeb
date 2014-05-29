/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author stud
 */
@Entity
public class Flights implements Serializable {
    private static final long serialVersionUID = 1L;
@Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flightName;
    private String arriveCity;
    private String totalCapacity;
    private String seatsAvailable;
    private String departureCity;
    
    private String className;
    @Column(unique = true)
    private String flightID;
    @Embedded
    
   // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   // @JoinColumn(name = "flights_id")
    private CancelledFlight canFlyt;
    private Status s;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "flights_id")
    private FlightDay flyDays;

   /* @Embedded
    private Reservation res; 
    List <ListOfFlights> lof;
    List <FlightDays> flyDays;
    @Embedded
    private CancelFlight canFlyt;
    List <SearchFlight> sFly;
   // @OneToMany

    @JoinColumn(name = "flight_id")
    @OneToMany(cascade = CascadeType.ALL)
    private Ticket tic;
    private FlightCapacity flyCap;
    private Passenger pass;
    */
    
 //   @JoinColumn(name = "flight_id")

      private Flights () {
    }
    
    private Flights(Builder builder)
    {
        id = builder.id;
        flightName = builder.flightName;
        arriveCity = builder.arriveCity;
        departureCity = builder.departureCity;
        totalCapacity = builder.totalCapacity;
        seatsAvailable = builder.seatsAvailable;
        className = builder.className;
        flightID = builder.flightID;
        canFlyt = builder.canFlyt;
         s = builder.s;
          flyDays = builder.flyDays;
          
      /*  res = builder.res;
        lof = builder.lof;
       
        
       
        tic = builder.tic;
        flyCap = builder.flyCap;
        pass = builder.pass;
      */
        
    }

    
    public static class Builder {
        
        
        private String flightName;
        private String arriveCity;
        private String departureCity;
        private String totalCapacity;
        private String seatsAvailable;
        private Long id;
        private String flightID;
        private CancelledFlight canFlyt;
        private String className;
        private Status s;
        private FlightDay flyDays;
       
      
   
        /*
        private Reservation res;
        private List<ListOfFlights> lof;
        
        private List<FlightDays> flyDays;
        private List<SearchFlight> sFly;
        private Ticket tic;
        private FlightCapacity flyCap;
        private Passenger pass;
    */

         public Builder(String flightID) {
             
            this.flightID = flightID;
        }
         
         public Builder id(Long value) {
            id = value;
            return this;
        }

        
        public Builder()
        {
            
        }
        
        public Builder flightName(String name)
        {
            flightName = name;
            return this;
        }
        
        public Builder arriveCity(String arrCity)
        {
            arriveCity = arrCity;
            return this;
        }
        
        public Builder departureCity(String deptCity)
        {
            departureCity = deptCity;
            return this;
        }
        
        public Builder totalCapacity(String tot)
        {
            totalCapacity = tot;
            return this;
        }
        
        public Builder seatsAvailable(String seatsAv)
        {
            seatsAvailable = seatsAv;
            return this;
        }
        
         public Builder className(String cName)
        {
            className = cName;
            return this;
        }
        
        public Builder canFlyt(CancelledFlight canf)
        {
            canFlyt = canf;
            return this;
            
        }
        
        public Builder s(Status st)
        {
            s = st;
            return this;
            
        }
        
        public Builder flyDays(FlightDay value) {
           
            flyDays = value;
            return this;
        }
    
       /* 
        public Builder res(Reservation value)
        {
            res = res;
            return this;
            
        }
        
       
        
       public Builder lof(List<ListOfFlights> value) {
           
            lof = value;
            return this;
        }
        
        
        
         public Builder sFly(List<SearchFlight> value) {
           
            sFly = value;
            return this;
        }
         
        public Builder tic(Ticket value)
        {
            tic = value;
            return this;
            
        }
        
        public Builder flyCap(FlightCapacity fly)
        {
            flyCap = fly;
            return this;
            
        }
        
        public Builder pass(Passenger p)
        {
            pass = p;
            return this;
            
        }*/
        
        public Builder flight(Flights f)
        {
            id = f.getId();
            flightName = f.getFlightName();
            arriveCity = f.getArriveCity();
            departureCity = f.getDepartureCity();
            totalCapacity = f.getTotalCapacity();
            seatsAvailable = f.getSeatsAvailable();
            flightID = f.getFlightID();
            canFlyt = f.getCanFlyt();
            className = f.getClassName();
            s = f.getS();
            flyDays = f.getFlyDays();
       
           /* res = f.getRes();
            tic = f.getTic();
            flyCap = f.getFlycap();
            pass = f.getPass();
           
              */
            return this;
             
        }


        public Flights build()
        {
           return new Flights(this);
            
        }
    
    }
    
    public String getFlightName() {
            return flightName;
        }

        public String getArriveCity() {
            return arriveCity;
        }

        public String getDepartureCity() {
            return departureCity;
        }

        public String getTotalCapacity() {
            return totalCapacity;
        }

        public String getSeatsAvailable() {
            return seatsAvailable;
        }

        public String getClassName() {
            return className;
        }
        
        public String getFlightID() {
            return flightID;
        }
        
        public CancelledFlight getCanFlyt() {
 
            
            return canFlyt;
        }

        public Status getS() {
            
        return s;
         }
        
          public FlightDay getFlyDays() {
            return flyDays;
        }
     
      /*  public Reservation getRes() {
            return res;
        }

        public List<ListOfFlights> getLof() {
            return lof;
        }

      

      

        public List<SearchFlight> getsFly() {
            return sFly;
        }
        
         public Ticket getTic() {
        return tic;
    }

    public FlightCapacity getFlycap() {
        return flyCap;
    }

    public Passenger getPass() {
        return pass;
    }*/

    public Long getId() {
        return id;
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
        if (!(object instanceof Flights)) {
            return false;
        }
        Flights other = (Flights) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sibu.flightsystemweb.domain.Flight[ id=" + id + " ]";
    }
    
}
