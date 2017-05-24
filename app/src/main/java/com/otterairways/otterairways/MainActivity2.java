package com.otterairways.otterairways;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import java.sql.Timestamp;

public class MainActivity2 extends AppCompatActivity {

    public EditText username1;
    public EditText password1;
    public TextView text;
    public String username;
    public String password;
    public Button but;
    public String s="mackle543";
    public String t="mackle543";
    public ArrayList<Customer>customer=new ArrayList<Customer>();
    public boolean isduplicate=false;
    public MySQLiteHelper db = new MySQLiteHelper(MainActivity2.this);
    public Customer cus=new Customer ("mackle543","password");
    public Button main_menu;
    public SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    String time = sdf.format(new Date());
    public String n="works";
    public Calendar cal = Calendar.getInstance();
    public DateFormat outputFormat = new SimpleDateFormat("KK:mm a");
   public String time2 = outputFormat.format(cal.getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username1=(EditText) findViewById(R.id.editText);
        password1=(EditText) findViewById(R.id.editText2);
        but=(Button)findViewById(R.id.button5);
        username=username1.getText().toString();
        password=password1.getText().toString();
        password1=(EditText) findViewById(R.id.editText2);
        customer= db.getAllCustomer();

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Customer x: customer) {
                    if (username1.getText().toString().equals(x.get_u_name()))
                    {
                        isduplicate=true;
                        break;
                    }
                    else
                    {
                        isduplicate=false;
                    }

                    }
                if(isduplicate==false)
                {
                    if(username1.getText().toString().equals(password1.getText().toString()))
                    {
                        db.addCustomer(new Customer(username1.getText().toString(), password1.getText().toString()));
                        customer.add(new Customer(username1.getText().toString(), password1.getText().toString()));
                        n=username1.getText().toString();
                        Toast.makeText(MainActivity2.this, "Registration was successful!", Toast.LENGTH_LONG).show();
                        Intent toy = new Intent(MainActivity2.this, MainActivity.class);
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity2.this);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("string_id",n);//InputString: from the EditText
                        editor.putString("id2",time);
                        editor.putString("id3",time2);
                        editor.commit();
                        startActivity(toy);
                        password1.setText(" ");
                    }
                    else
                    {
                        Toast.makeText(MainActivity2.this,"invalid username",Toast.LENGTH_LONG).show();
                        password1.setText("");

                    }
                }
                else{
                         AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                        builder.setMessage("Invalid username")
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent toy = new Intent(MainActivity2.this, MainActivity.class);
                                    startActivity(toy);
                                }
                            }).setNegativeButton("cancel",null);
                        AlertDialog alert =builder.create();
                        alert.show();
                }

            }
        });
        main_menu=(Button) findViewById(R.id.mainmenu);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(toy);
            }
        });

    }


}
