package com.otterairways.otterairways;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Cancell extends AppCompatActivity {
    public EditText text,text1;
    public MySQLiteHelper db = new MySQLiteHelper(this);
    public ArrayList<Reserve> reservations=new ArrayList<Reserve>();
    public ArrayList<String> temp=new ArrayList<String>();
    public ListView mosList;
    public Button submit;
    public boolean flag=false;
    public Reserve temp1;
    public String temp2;
    public SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    public String time = sdf.format(new Date());
    public Calendar cal = Calendar.getInstance();
    public DateFormat outputFormat = new SimpleDateFormat("KK:mm a");
    public String time2 = outputFormat.format(cal.getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancell);
        text=(EditText)findViewById(R.id.editText8);
        text1=(EditText)findViewById(R.id.editText9);
        reservations=db.getAllReservations();
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Reserve x:reservations)
                {
                    if(x.get_u_name().equals(text.getText().toString()))
                    {
                        temp2=x.toString();
                        temp.add(x.toString());
                        String[] arr = temp.toArray(new String[temp.size()]);
                        ListAdapter mosadapter=new ArrayAdapter<String>(Cancell.this,android.R.layout.simple_list_item_1,arr);
                        mosList=(ListView) findViewById(R.id.Reserves);
                        mosList.setAdapter(mosadapter);
                        mosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                                TextView textview=(TextView)viewClicked;
                                for(Reserve x:reservations)
                                {
                                    if(textview.getText().equals(x.toString()))
                                    {
                                        temp1=x;
                                        AlertDialog.Builder builder = new AlertDialog.Builder(Cancell.this);
                                        builder.setMessage("Are you sure you want to Cancel?")
                                                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        db.deleteReservation(temp1);
                                                        Toast.makeText(Cancell.this,"Reservation has been cancelled",Toast.LENGTH_LONG).show();
                                                        Intent toy = new Intent(Cancell.this, MainActivity.class);
                                                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Cancell.this);
                                                        SharedPreferences.Editor editor = prefs.edit();
                                                        editor.putString("id",temp2);//InputString: from the EditText
                                                        editor.putString("id4",time);
                                                        editor.putString("id5",time2);
                                                        editor.commit();
                                                        startActivity(toy);
                                                    }
                                                }).setNegativeButton("cancel",null);
                                        AlertDialog alert =builder.create();
                                        alert.show();

                                    }


                                }
                            }
                        });
                        flag=true;
                        break;
                    }
                    else
                    {
                        flag=false;
                    }

                }
                text.setText("");
                text1.setText("");
                if(flag==false)
                {
                    Toast.makeText(Cancell.this,"Sorry no reservation under that name",Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
