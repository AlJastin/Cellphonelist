package com.example.cellphonelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Edit_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Table_screen.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, Table_screen.class);
        startActivity(intent);
    }
}