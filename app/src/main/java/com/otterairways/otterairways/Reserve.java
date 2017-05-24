package com.otterairways.otterairways;

/**
 * Created by Mohamad on 5/11/2017.
 */

public class Reserve {
    private int id;
    private String f_number;
    private String username;
    private String departure;
    private String arrival;
    private String time;
    private String price;


    public Reserve(String username,String f_number,String departure,String arrival,String time,String price)
    {
        this.username=username;
        this.f_number=f_number;
        this.departure=departure;
        this.arrival=arrival;
        this.time=time;
        this.price=price;
    }


    public Reserve()
    {
        this.username=null;
        this.f_number=null;
        this.departure=null;
        this.arrival=null;
        this.time=null;
        this.price=null;
    }
    public int get_id()
    {
        return this.id;
    }
    public void set_id(int id)
    {
        this.id=id;
    }
    public String get_u_name() {return this.username;}
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
    public String get_time()
    {
        return time;
    }
    public String get_price() {return price;}
    public void set_u_name(String username) {this.username=username;}
    public void set_f_number(String f_number)
    {
        this.f_number=f_number;
    }
    public void set_arrival(String arrival) {this.arrival=arrival;}
    public void set_departure(String departure) {this.departure=departure;}
    public void set_time(String time)
    {
        this.time=time;
    }
    public void set_price(String price)
    {
        this.price=price;
    }
    public String toString()
    {
       return "Reservation [id: "+this.id+" username: " + this.username + ", flight number: " + this.f_number +
                ", departure: "+this.departure+ ", arrival: "+this.arrival+" time: "+this.time+" price: "+this.price+" ]";

    }



}
