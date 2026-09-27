package com.example.smartpantrymanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PantryDbHelper extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME ="pantry.db";
    private  static final  int DATABASE_VERSION=1;
    public static final String TABLE_NAME ="pantry";
    public static final String COLUMN_ID ="id";
    public static final String COLUMN_NAME ="itemName";
    public static final String COLUMN_QUANTITY ="quantity";
    public static final String COLUMN_EXPIRY ="expiryDate";

    public PantryDbHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " TEXT NOT NULL," +
                COLUMN_QUANTITY + " INTEGER NOT NULL," +
                COLUMN_EXPIRY + " TEXT)");
    }

    @Override
    public void  onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}