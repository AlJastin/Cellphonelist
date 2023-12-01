package com.example.cellphonelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Table_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_screen);
    }

    public void back(View view) {
        Intent intent = new Intent(this, ADD_Screen.class);
        startActivity(intent);
    }
}