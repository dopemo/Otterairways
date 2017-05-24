package com.otterairways.otterairways;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {
    public Button res,addflight,viewFlights,main_menu,verify_account,verify_cancellation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        res=(Button) findViewById(R.id.Reservations);
        addflight=(Button) findViewById(R.id.addflight);
        viewFlights=(Button) findViewById(R.id.flights);
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(AdminActivity.this,ViewRes.class);
                startActivity(toy);
            }
        });
        viewFlights.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent toy=new Intent(AdminActivity.this,ViewFlights.class);
                startActivity(toy);
            }


        });
        addflight.setOnClickListener(new View.OnClickListener(){

        public void onClick(View v)
        {
            Intent toy=new Intent(AdminActivity.this,addflight.class);
            startActivity(toy);
        }

        });
        main_menu=(Button)findViewById(R.id.button10);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(AdminActivity.this,ManageSystem.class);
                startActivity(toy);

            }
        });
        verify_account=(Button) findViewById(R.id.button11);
        verify_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(AdminActivity.this,VerifyAccount.class);
                startActivity(toy);
            }
        });
        verify_cancellation=(Button) findViewById(R.id.cb);
        verify_cancellation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(AdminActivity.this,VerifyCancellation.class);
                startActivity(toy);
            }
        });




    }
}
