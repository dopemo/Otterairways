package com.otterairways.otterairways;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.Short.valueOf;

public class addflight extends AppCompatActivity {
    public EditText f_number,departure,arrival,tickets,time, price;
    public MySQLiteHelper db = new MySQLiteHelper(this);
    public ArrayList<Flights>flights=new ArrayList<Flights>();
    public boolean flag=true;
    public Button button,main_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addflight);
        f_number=(EditText)findViewById(R.id.flight_number);
        departure=(EditText)findViewById(R.id.dept);
        arrival=(EditText)findViewById(R.id.arrival);
        tickets=(EditText)findViewById(R.id.tickets);
        time=(EditText)findViewById(R.id.time);
        price=(EditText)findViewById(R.id.price);
        button=(Button)findViewById(R.id.flightadd);
        flights=db.getAllFlights();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Flights x:flights)
                {
                    if(x.get_f_number().equals(f_number.getText().toString()))
                    {
                        flag=false;
                        break;
                    }
                    else
                    {
                        flag=true;
                    }
                }
                if(flag==true)
                {

                    int temp=10;
                    db.addFlight(new Flights(f_number.getText().toString(),departure.getText().toString(),arrival.getText().toString(),temp,time.getText().toString(),price.getText().toString()));
                    f_number.setText("");
                    departure.setText("");
                    arrival.setText("");
                    tickets.setText("");
                    time.setText("");
                    price.setText("");
                    Toast.makeText(addflight.this,"Flight has been added",Toast.LENGTH_LONG).show();
                }
                else
                {
                    f_number.setText("");
                    departure.setText("");
                    arrival.setText("");
                    tickets.setText("");
                    time.setText("");
                    price.setText("");
                    Toast.makeText(addflight.this,"Flight number has already been used",Toast.LENGTH_LONG).show();
                }
            }
        });
        main_menu=(Button)findViewById(R.id.button8);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(addflight.this,MainActivity.class);
                startActivity(toy);
            }
        });




    }
}
