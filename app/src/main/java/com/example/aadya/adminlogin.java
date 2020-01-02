package com.example.aadya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {

    EditText usern,passw;
    Button log;
    String susern,spassw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        usern=(EditText)findViewById(R.id.user);
        passw=(EditText)findViewById(R.id.pass);

        log=(Button)findViewById(R.id.log);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                susern=usern.getText().toString();
                spassw=passw.getText().toString();

                if(susern.isEmpty())
                {
                    usern.setError("username is required");
                    usern.requestFocus();
                }
                else if(spassw.isEmpty())
                {
                    passw.setError("password is required");
                    passw.requestFocus();
                }
               else
                {
                    if(susern.equals("nandana")&&spassw.equals("12345"))
                    {
                        Toast.makeText(getApplicationContext(),"successfully logged in",Toast.LENGTH_LONG).show();

                        Intent inte = new Intent(getApplicationContext(), adminpage.class);
                        startActivity(inte);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Incorrect username or password",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
