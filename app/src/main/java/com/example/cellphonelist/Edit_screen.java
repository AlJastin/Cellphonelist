package com.example.cellphonelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_screen extends AppCompatActivity {
    EditText editPhoneModel, editPrice, editOs, editSpecs;
    Button btnSaveChanges;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);

        // Initialize UI components
        editPhoneModel = findViewById(R.id.EditPhoneModel);
        editPrice = findViewById(R.id.Editprice);
        editOs = findViewById(R.id.Editos);
        editSpecs = findViewById(R.id.Editspecs);
        btnSaveChanges = findViewById(R.id.submit);

        // Get data passed from the Adapter
        Intent intent = getIntent();
        if (intent != null) {
            String phoneModel = intent.getStringExtra("phone_model");
            String price = intent.getStringExtra("price");
            String os = intent.getStringExtra("OS");
            String specs = intent.getStringExtra("SPECS");

            // Populate the UI components with the retrieved data
            editPhoneModel.setText(phoneModel);
            editPrice.setText(price);
            editOs.setText(os);
            editSpecs.setText(specs);
        }

        // Set click listener for the "Save Changes" button
        btnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the update operation here (e.g., update data in the database)
                updateData();
            }
        });
    }

    private void updateData() {
        // Retrieve edited data from the UI components
        String updatedPhoneModel = editPhoneModel.getText().toString();
        String updatedPrice = editPrice.getText().toString();
        String updatedOs = editOs.getText().toString();
        String updatedSpecs = editSpecs.getText().toString();

        // Perform the update operation (e.g., update data in the database)
        // Replace this with your actual database update logic
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.updateUserData(updatedPhoneModel, updatedPrice, updatedOs, updatedSpecs);

        // Optionally, you can set a result to indicate success or failure
        Intent resultIntent = new Intent();
        setResult(RESULT_OK, resultIntent);

        // Finish the activity
        finish();
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