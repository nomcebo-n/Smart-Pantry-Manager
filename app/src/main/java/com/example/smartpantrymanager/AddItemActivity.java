package com.example.smartpantrymanager;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    private PantryRepository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        repo = new PantryRepository(this);

        EditText nameInput = findViewById(R.id.itemNameInput);
        EditText quantityInput = findViewById(R.id.itemQuantityInput);
        EditText expiryInput = findViewById(R.id.itemExpiryInput);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v->{
            String name = nameInput.getText().toString().trim();
            String quantityStr = quantityInput.getText().toString().trim();
            String expiry = expiryInput.getText().toString().trim();

            if(name.isEmpty()|| quantityStr.isEmpty()|| expiry.isEmpty()){
                Toast.makeText(this,"Please fill in all the fields.", Toast.LENGTH_SHORT).show();
                return;
            }

            int quantity = Integer.parseInt(quantityStr);
            long result = repo.addItems(name, quantity, expiry);

            if(result != -1){
                Toast.makeText(this,"Item saved.", Toast.LENGTH_SHORT).show();
                finish();
            } else{
                Toast.makeText(this, "Error saving item",Toast.LENGTH_SHORT).show();
            }
        });


    }
}