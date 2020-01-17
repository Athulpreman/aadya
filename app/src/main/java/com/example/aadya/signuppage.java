package com.example.aadya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signuppage extends AppCompatActivity {

    EditText euser,epass,emob;
    Button signin;
    String suse,spas,smob;
    User user;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        euser=(EditText)findViewById(R.id.use);
        epass=(EditText)findViewById(R.id.pas);
        emob=(EditText)findViewById(R.id.mobile);
        user=new User();
        reference= FirebaseDatabase.getInstance().getReference().child("User");

        signin=(Button)findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                suse=euser.getText().toString();
                spas=epass.getText().toString();
                smob=emob.getText().toString();

                user.setUsername(suse);
                user.setPassword(spas);
                user.setMobile(smob);

                reference.push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                    }
                });

                Intent inten=new Intent(getApplicationContext(),userloggedin.class);
                startActivity(inten);
            }
        });
    }
}
