package com.otterairways.otterairways;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class VerifyCancellation extends AppCompatActivity {
    public ArrayList<String> ac_info=new ArrayList<String>();
    public ListView mosList;
    public String d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_cancellation);
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(VerifyCancellation.this);
        String data ="Transcation Type: New Account"+"\nCustomers username: " +prefs.getString("id", "no id");
        data+= "\nTransaction Date: "+prefs.getString("id4","no id2");
        data+= "\nTransaction Time: "+prefs.getString("id5","no id3");
        d=data;
        ac_info.add(d);
        String[] arr=ac_info.toArray(new String[ac_info.size()]);
        ListAdapter mosadapter=new ArrayAdapter<String>(VerifyCancellation.this,android.R.layout.simple_list_item_1,arr);
        mosList=(ListView) findViewById(R.id.clv);
        mosList.setAdapter(mosadapter);


    }
}
