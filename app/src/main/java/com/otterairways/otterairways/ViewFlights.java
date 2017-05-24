package com.otterairways.otterairways;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewFlights extends AppCompatActivity {
    public MySQLiteHelper db = new MySQLiteHelper(this);
    public ArrayList<Flights>flights=new ArrayList<Flights>();
    public ArrayList<String>temps=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flights);
        flights=db.getAllFlights();
        for(Flights x:flights)
        {
            temps.add(x.toString());
            String[] arr = temps.toArray(new String[temps.size()]);
            ListAdapter mosadapter=new ArrayAdapter<String>(ViewFlights.this,android.R.layout.select_dialog_item,arr);
            ListView mosList=(ListView) findViewById(R.id.flights);
            mosList.setAdapter(mosadapter);
        }
    }
}
