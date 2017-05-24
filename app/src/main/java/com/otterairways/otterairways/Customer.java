package com.otterairways.otterairways;

/**
 * Created by Mohamad on 5/5/2017.
 */

public class Customer {
    private String name;
    private String username;
    private String password;
    private String reserver;
    private String depature;
    private String arrival;
    public Customer(String username,String password) {this.username = username;this.password = password;}
    public Customer(){this.password=null;}
    public String get_name()
    {
        return this.name;
    }
    public String get_u_name() {return this.username;}
    public String get_pass() {return this.password;}
    public void set_name(String name)
    {
        this.name=name;
    }
    public void set_u_name(String username)
    {
        this.username=username;
    }
    public void set_pass(String password)
    {
        this.password=password;
    }
    public String get_r_num()
    {
        return this.reserver;
    }
    public void set_r_num(String reserver)
    {
        this.reserver=reserver;
    }
    public String toString()
    {
        return "CUSTOMER [username=" + this.username + ", password=" + this.password +
                " ]";

    }


}
