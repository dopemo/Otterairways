package com.otterairways.otterairways;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManageSystem extends AppCompatActivity {
    public String admin="!admiM2";
    public String password="!admiM2";
    public EditText u_admin;
    public EditText admin_pas;
    public Button but;
    public Button but1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_system);
        u_admin=(EditText) findViewById(R.id.editText6);
        admin_pas=(EditText) findViewById(R.id.editText7);
        but=(Button)findViewById(R.id.Login);
        but1=(Button)findViewById(R.id.button9);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(u_admin.getText().toString().toString().equals(admin))
                {
                    if(admin_pas.getText().toString().toString().equals(password))
                    {
                        u_admin.setText("");
                        admin_pas.setText("");
                        Intent toy=new Intent(ManageSystem.this, AdminActivity.class);
                        startActivity(toy);

                    }
                    else
                    {
                        Toast.makeText(ManageSystem.this, "Sorry incorrect password or username!", Toast.LENGTH_LONG).show(); u_admin.setText("");
                        admin_pas.setText("");
                        u_admin.setText("");

                    }
                }
                else
                {
                    Toast.makeText(ManageSystem.this, "Sorry incorrect password or username!", Toast.LENGTH_LONG).show(); u_admin.setText("");
                    admin_pas.setText("");
                    u_admin.setText("");

                }
            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(ManageSystem.this,MainActivity.class);
                startActivity(toy);
            }
        });


    }
}
