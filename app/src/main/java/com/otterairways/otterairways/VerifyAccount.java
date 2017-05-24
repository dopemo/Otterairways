package com.otterairways.otterairways;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class VerifyAccount extends AppCompatActivity {
    public ArrayList<String> ac_info=new ArrayList<String>();
    public ListView mosList;
    public BroadcastReceiver mReceiver;
    public String n;
    public TextView text2;
    public String d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_account);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String data ="Transcation Type: New Account"+"\nCustomers username: " +prefs.getString("string_id", "no id");
        data+= "\nTransaction Date: "+prefs.getString("id2","no id2");
        data+= "\nTransaction Time: "+prefs.getString("id3","no id3");
        d=data;
        ac_info.add(d);
        String[] arr=ac_info.toArray(new String[ac_info.size()]);
        ListAdapter mosadapter=new ArrayAdapter<String>(VerifyAccount.this,android.R.layout.simple_list_item_1,arr);
        mosList=(ListView) findViewById(R.id.lV);
        mosList.setAdapter(mosadapter);





    }
}
