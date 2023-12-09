package com.example.cellphonelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Table_screen extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> phone, price, os, specs;
    DBHelper DB;
    Adapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_screen);
        DB = new DBHelper(this);
        phone = new ArrayList<>();
        price = new ArrayList<>();
        os = new ArrayList<>();
        specs = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview1);
        adapter = new Adapter(this, phone, price, os, specs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata() {
        Cursor cursor = DB.getdata();
        if (cursor.getCount() == 0) {
            Toast.makeText(Table_screen.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                phone.add(cursor.getString(0));
                price.add(cursor.getString(1));
                os.add(cursor.getString(2));
                specs.add(cursor.getString(3));
            }
        }
    }


    public void back(View view) {
        Intent intent = new Intent(this, ADD_Screen.class);
        startActivity(intent);
    }
}