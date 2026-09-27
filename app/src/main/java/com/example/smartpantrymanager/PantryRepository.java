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

    public List<PantryItem> getAllItems() {
        List<PantryItem> items = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(PantryDbHelper.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(PantryDbHelper.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(PantryDbHelper.COLUMN_NAME));
            int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(PantryDbHelper.COLUMN_QUANTITY));
            String expiry = cursor.getString(cursor.getColumnIndexOrThrow(PantryDbHelper.COLUMN_EXPIRY));
            items.add(new PantryItem(id, name, quantity, expiry));
        }
        cursor.close();
        return items;

    }

}
