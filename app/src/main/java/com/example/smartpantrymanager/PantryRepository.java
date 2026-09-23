package com.example.smartpantrymanager;

import android.content.ContentValues;
import android.content.ContextValues;
import android.content.Context;
import android.database..Cursor;
import  android.database.sqlite.SQLiteDatabase;

public class PantryRepository  {
    private final PantryDbHelper dbHelper;

    public PantryRepository(Context context){
        dbHelper = new PantryDbHelper(context);
    }
    public long addItems(String name, int quantity, String expiryDate){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("itemName",name);
        values.put("quantity",quantity);
        values.put("expiryDate",expiryDate);
        return db.update("pantry", values,"id=?", new String[]{String.valueOf(id)});
    }

    public int deleteItem(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete("pantry", "id=?", new String[]{String.valueOf(id)});
    }
}
