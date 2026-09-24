package com.example.smartpantrymanager;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import androidx.recyclerview.widget.RecyclerView;


public class PantryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);


        //will find the RecyclerView in the layout
        RecyclerView= findViewById(R.id.pantryRecyclerView);

        //will get data from the database
        PantryRepository repo = new PantryRepository(this);
        Cursor cursor = repo.getAllItems();

        //will connect to adapter to recycleview
        PantryAdapter = new PantryAdapter(this,cursor);

    }
}