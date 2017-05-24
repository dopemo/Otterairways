package com.otterairways.otterairways;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TravelInfo extends AppCompatActivity {
public ArrayList<Flights>flights=new ArrayList<Flights>();
    public MySQLiteHelper db = new MySQLiteHelper(TravelInfo.this);
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_info);
        Bundle bundle=getIntent().getExtras();
        String s=bundle.getString("username");
        String p=bundle.getString("flight_info");
        flights=db.getAllFlights();
        TextView text=(TextView)findViewById(R.id.textView13);
        for(Flights x:flights)
        {
            if(x.get_f_number().equals(p))
            {
                Reserve res=new Reserve(s,x.get_f_number(),x.get_departure(),x.get_arrival(),x.get_time(),x.get_price());
                db.addReservation(res);
                text.setText(res.toString());

            }
        }
        button=(Button)findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(TravelInfo.this,MainActivity.class);
                startActivity(toy);
            }
        });



    }
}
