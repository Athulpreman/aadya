package com.example.aadya.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.aadya.R;
import com.example.aadya.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {
    String userName;
    TextView name,mobile,password;
    Button button;
    DatabaseReference ref;

    String s1,s2,s3;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s)
            {
                name=(TextView)root.findViewById(R.id.name);
                mobile=(TextView)root.findViewById(R.id.mobile);
                password=(TextView)root.findViewById(R.id.passw);
                button=(Button)root.findViewById(R.id.butto);

                ref=FirebaseDatabase.getInstance().getReference().child("User");

                Intent inte=getActivity().getIntent();
                userName=inte.getStringExtra("username");

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Query query=ref.orderByChild("username").equalTo(userName);
                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                for (DataSnapshot datasnap:dataSnapshot.getChildren())
                                {
                                    User us=datasnap.getValue(User.class);



                                    s1=us.username;
                                    s2=us.mobile;
                                    s3=us.password;

                                    name.setText(s1);
                                    mobile.setText(s2);
                                    password.setText(s3);
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                });
            }
        });
        return root;
    }
}