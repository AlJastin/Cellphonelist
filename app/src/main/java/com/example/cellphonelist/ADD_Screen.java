package com.example.cellphonelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ADD_Screen extends AppCompatActivity {
    EditText phoneModel, price, os, specs;
    Button insert, view;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);

        phoneModel = findViewById(R.id.phone_model);
        price = findViewById(R.id.price);
        os = findViewById(R.id.os);
        specs = findViewById(R.id.specs);
        insert = findViewById(R.id.submit);
        view = findViewById(R.id.view);

        DB = new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ADD_Screen.this, Table_screen.class));
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneModelTXT = phoneModel.getText().toString();
                String priceTXT = price.getText().toString();
                String osTXT = os.getText().toString();
                String specsTXT = specs.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(phoneModelTXT, priceTXT, osTXT, specsTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(ADD_Screen.this,"New Phone Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ADD_Screen.this,"New Phone Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void back(View view) {
        Intent intent = new Intent(this, home_screen.class);
        startActivity(intent);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Table_screen.class);
        startActivity(intent);
    }
}