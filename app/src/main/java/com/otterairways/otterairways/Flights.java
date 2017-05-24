package com.otterairways.otterairways;

import com.otterairways.otterairways.Customer;

import java.util.ArrayList;

/**
 * Created by Mohamad on 5/5/2017.
 */
public class Flights {

    ArrayList<Customer> cutomer=new ArrayList<Customer>();
    private int id;
    private String f_number;
    private String departure;
    private String arrival;
    private int tickets;
    private String time;
    private String price;
    public Flights(String f_number,String departure,String arrival, int tickets,String time,String price)
    {
        this.f_number=f_number;
        this.departure=departure;
        this.arrival=arrival;
        this.tickets=tickets;
        this.time=time;
        this.price=price;
    }
    public Flights()
    {
        this.departure=null;
        this.arrival=null;
        this.tickets=0;
        this.time=null;
        this.price=null;

    }
   public String getF_info()
   {
       return this.departure+" "+this.arrival+" ";
   }
   public String get_f_number()
   {
       return this.f_number;
   }
   public String get_arrival()
   {
       return this.arrival;
   }
   public String get_departure()
   {
       return this.departure;
   }
   public int get_tickets() {return this.tickets;}
   public String get_time()
   {
       return time;
   }
   public String get_price() {return price;}
   public void set_f_number(String f_number)
    {
        this.f_number=f_number;
    }
    public void set_arrival(String arrival) {this.arrival=arrival;}
    public void set_departure(String departure) {this.departure=departure;}
    public void set_tickets(int tickets) { this.tickets=tickets;}
    public void set_time(String time)
    {
        this.time=time;
    }
    public void set_price(String price)
    {
        this.price=price;
    }
    public String toString() {return "FLIGHTS [flight=" + this.f_number + ", departure=" + this.departure +
                ", arrival= "+this.arrival+" tickets:" + this.tickets+" "+this.time+" "+this.price+" ]";}

}
