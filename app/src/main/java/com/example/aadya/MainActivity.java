package com.example.aadya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText user,pass;
    Button login;
    TextView signup,admin;
    ImageButton fb;
    String suser,spass;
    DatabaseReference refe;

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

        refe= FirebaseDatabase.getInstance().getReference().child("User");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                suser=user.getText().toString();
                spass=pass.getText().toString();

                Query query=refe.orderByChild("username").equalTo("suser");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                        {
                            User ob=dataSnapshot1.getValue(User.class);
                            String pass=ob.password;

                            if(pass.equals(spass))
                            {
                                Intent intu=new Intent(getApplicationContext(),userloggedin.class);
                                startActivity(intu);

                                Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
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
