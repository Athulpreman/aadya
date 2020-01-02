package com.example.aadya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signuppage extends AppCompatActivity {

    EditText euser,epass,emob;
    Button signin;
    String suse,spas,smob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        euser=(EditText)findViewById(R.id.use);
        epass=(EditText)findViewById(R.id.pas);
        emob=(EditText)findViewById(R.id.mobile);

        signin=(Button)findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                suse=euser.getText().toString();
                spas=epass.getText().toString();
                smob=emob.getText().toString();

                Intent inten=new Intent(getApplicationContext(),userloggedin.class);
                startActivity(inten);
            }
        });
    }
}
