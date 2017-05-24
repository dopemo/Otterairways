package com.otterairways.otterairways;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.String.valueOf;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class ReserveSeat extends AppCompatActivity {
    public MySQLiteHelper db = new MySQLiteHelper(this);
    public ArrayList<Flights>flights=new ArrayList<Flights>();
    public EditText departure;
    public EditText arrival;
    public Button button;
    public TextView text3;
    public String temp;
    public ArrayList<String>f_numbers=new ArrayList<String>();
    public ArrayList<Customer>customers=new ArrayList<Customer>();
    public EditText text;
    public EditText text1;
    public EditText tickets;
    public boolean flag=true;
    public ListView mosList;
    public boolean flag2=true;
    public int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_seat);
        departure=(EditText)findViewById(R.id.editText3);
        arrival=(EditText) findViewById(R.id.editText4);
        flights=db.getAllFlights();
        button=(Button) findViewById(R.id.button6);
        customers=db.getAllCustomer();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Flights x: flights)
                {
                    if(departure.getText().toString().contains(x.get_departure()))
                    {
                        if(arrival.getText().toString().contains(x.get_arrival()))
                        {
                            f_numbers.add(x.get_f_number());
                            String[] arr = f_numbers.toArray(new String[f_numbers.size()]);
                            ListAdapter mosadapter=new ArrayAdapter<String>(ReserveSeat.this,android.R.layout.simple_list_item_1,arr);
                            mosList=(ListView) findViewById(R.id.moslistview);
                            mosList.setAdapter(mosadapter);
                            i++;


                        }

                    }


                }
                if(i>0)
                {
                    mosList.setOnItemClickListener(new AdapterView.OnItemClickListener()
                    {


                        @Override
                        public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id)
                        {
                            TextView textview=(TextView)viewClicked;
                            for(Flights x:flights)
                            {
                                if(x.get_f_number().equals(textview.getText().toString()))
                                {
                                    View v= LayoutInflater.from(ReserveSeat.this).inflate(R.layout.activity_alertlogin,null);
                                    text=(EditText) v.findViewById(R.id.editText10);
                                    text1=(EditText)v.findViewById(R.id.editText11);
                                    temp=x.get_f_number();

                                    AlertDialog.Builder builder = new AlertDialog.Builder(ReserveSeat.this);
                                    builder.setMessage("Login")
                                            .setView(v)
                                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {

                                                    for(Customer x:customers)
                                                    {
                                                        if(x.get_u_name().equals(text.getText().toString()))
                                                        {
                                                            if(x.get_pass().equals(text1.getText().toString()))
                                                            {
                                                                Intent toy=new Intent(ReserveSeat.this,TravelInfo.class);
                                                                Bundle bundle=new Bundle();
                                                                bundle.putString("username",x.get_u_name());
                                                                bundle.putString("flight_info",temp);
                                                                toy.putExtras(bundle);
                                                                startActivity(toy);
                                                                text.setText("");
                                                                text1.setText("");
                                                                flag2=true;
                                                                break;

                                                            }
                                                            else
                                                            {

                                                                flag2=false;
                                                            }
                                                        }
                                                        else
                                                        {
                                                            flag2=false;
                                                        }


                                                    }
                                                    if(flag2==false)
                                                    {
                                                        departure.setText("");
                                                        arrival.setText("");
                                                        EditText text=(EditText)findViewById(R.id.editText5);
                                                        text.setText("");
                                                        Toast.makeText(ReserveSeat.this,"Sorry you were not found in our records!",Toast.LENGTH_LONG).show();
                                                    }

                                                }
                                            }).setNegativeButton("cancel",null);
                                    AlertDialog alert =builder.create();
                                    alert.show();
                                }
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(ReserveSeat.this,"Sorry we do not have flights from "+departure.getText().toString()+" to "+ arrival.getText().toString(),Toast.LENGTH_LONG).show();
                    departure.setText("");
                    arrival.setText("");
                    tickets=(EditText) findViewById(R.id.editText5);
                    tickets.setText("");

                }





            }

        });



    }

}
