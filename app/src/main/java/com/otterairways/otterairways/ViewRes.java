package com.otterairways.otterairways;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewRes extends AppCompatActivity {
    public MySQLiteHelper db = new MySQLiteHelper(this);
    public ArrayList<Reserve>reservations=new ArrayList<Reserve>();
    public ArrayList<String>temps=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_res);
        reservations=db.getAllReservations();
        for(Reserve x:reservations)
        {
            temps.add(x.toString());
            String[] arr = temps.toArray(new String[temps.size()]);
            ListAdapter mosadapter=new ArrayAdapter<String>(ViewRes.this,android.R.layout.select_dialog_item,arr);
            ListView mosList=(ListView) findViewById(R.id.mylist);
            mosList.setAdapter(mosadapter);
        }



    }
}
