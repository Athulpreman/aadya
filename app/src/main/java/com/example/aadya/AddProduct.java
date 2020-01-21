package com.example.aadya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProduct extends AppCompatActivity {
    EditText name,rating,price;
    Button b;
    String pname,prating,pprice;
    Product product;
    DatabaseReference refer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        name=(EditText)findViewById(R.id.ProductName);
        rating=(EditText)findViewById(R.id.Rating);
        price=(EditText)findViewById(R.id.Price);

        b=(Button)findViewById(R.id.UploadProduct);

        product=new Product();

        refer= FirebaseDatabase.getInstance().getReference().child("Product");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pname=name.getText().toString();
                prating=rating.getText().toString();
                pprice=price.getText().toString();

                product.setProductname(pname);
                product.setProductrating(prating);
                product.setProductprice(pprice);

                refer.push().setValue(product).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}
