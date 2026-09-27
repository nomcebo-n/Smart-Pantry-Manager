package com.example.smartpantrymanager;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class PantryActivity extends AppCompatActivity {
    private PantryRepository repo;
    private  PantryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        repo = new PantryRepository(this);


        //will find the RecyclerView in the layout
        RecyclerView recyclerView= findViewById(R.id.pantryRecyclerView);
        adapter = new PantryAdapter(repo.getAllItems());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button addButton  = findViewById(R.id.addButton);
        addButton.setOnClickListener(v->{
            Intent intent =new Intent(PantryActivity.this, AddItemActivity.class);
            startActivity(intent);
        });

    }
    @Override
    protected  void onResume(){
        super.onResume();
        adapter.updateData(repo.getAllItems());
    }
}