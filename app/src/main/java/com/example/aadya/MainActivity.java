package com.example.aadya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText user,pass;
    Button login;
    TextView signup,admin;
    ImageButton fb;
    String suser,spass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);

        login=(Button)findViewById(R.id.login);

        signup=(TextView)findViewById(R.id.signup);
        admin=(TextView)findViewById(R.id.admin);

        fb=(ImageButton)findViewById(R.id.img);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),signuppage.class);
                startActivity(intent);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(getApplicationContext(),adminlogin.class);
                startActivity(in);
            }
        });

    }
}
