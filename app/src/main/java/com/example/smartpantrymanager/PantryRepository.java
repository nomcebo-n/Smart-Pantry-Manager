package com.example.smartpantrymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import  android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class PantryRepository  {
    private final PantryDbHelper dbHelper;

    public PantryRepository(Context context){
        dbHelper = new PantryDbHelper(context);
    }
    public long addItems(String name, int quantity, String expiryDate){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PantryDbHelper.COLUMN_NAME,name);
        values.put(PantryDbHelper.COLUMN_QUANTITY,quantity);
        values.put(PantryDbHelper.COLUMN_EXPIRY,expiryDate);
        return db.insert(PantryDbHelper.TABLE_NAME, null, values);
    }

    public List<Pantry>

    public Cursor getAllItems(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.query(
                "pantry",  // The b+table name
                null,           // All the columns
                null,              // Selection
                null,              // Selection args
                null,              //Group by
                null,           // Having
                "itemName ASC"  // Order by
        );
    }

}
