package com.example.smartpantrymanager;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;


public class PantryItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_item);

        // Will get the data from PantryAdapter
        String name = getIntent().getStringExtra("name");
        int quantity = getIntent().getIntExtra("quantity",0);
        String expiry = getIntent().getStringExtra("expiry");


        // Bind to views
        TextView detailName = findViewById(R.id.detailName);
        TextView detailQuantity = findViewById(R.id.detailQuantity);
        TextView detailExpiry = findViewById(R.id.detailExpiry);

        detailName.setText(name);
        detailQuantity.setText("Quantity: " +quantity);
        detailExpiry.setText("Expiry : "+ expiry);

    }
}