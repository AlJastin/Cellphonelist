package com.example.cellphonelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ADD_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);
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