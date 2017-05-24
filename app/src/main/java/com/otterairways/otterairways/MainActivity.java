package com.otterairways.otterairways;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import	android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.*;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public MySQLiteHelper db = new MySQLiteHelper(this);
    public ArrayList<Flights>flights=new ArrayList<Flights>();
    public ArrayList<Customer>customers=new ArrayList<Customer>();


    public Button but1, but2,but3,but4;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init() {
        but1 = (Button) findViewById(R.id.button2);
        but2 = (Button) findViewById(R.id.button);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(toy);
            }
        });
        ArrayList<Customer> customers = new ArrayList<Customer>();
        but1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, ReserveSeat.class);
                startActivity(toy);
            }

        });
        but3=(Button)findViewById(R.id.button3);
        but3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent toy=new Intent(MainActivity.this,ManageSystem.class);
                startActivity(toy);
            }
        } );

        flights=db.getAllFlights();
        if(flights.size()<4)
        {
            db.addFlight(new Flights("otter201","Monterey","Seattle",10,"11:00am","$401.00"));
            db.addFlight(new Flights("otter101","Los Angeles","Monterey",10,"1:00pm","$900"));
            db.addFlight(new Flights("otter102","Monterey","Los Angeles",10,"10:30am","$750.00"));
            db.addFlight(new Flights("otter205","Monterey","Seattle",8,"9:30am","$390.00"));

        }
        but4=(Button)findViewById(R.id.button4);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(MainActivity.this,Cancell.class);
                startActivity(toy);

            }
        });








    }
}