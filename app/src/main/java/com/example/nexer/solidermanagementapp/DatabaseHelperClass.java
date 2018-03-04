package com.example.nexer.solidermanagementapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by nexer on 14/02/2018.
 * References:
 * https://www.youtube.com/watch?v=p8TaTgr4uKM <- Tutorial Series
 */

public class DatabaseHelperClass extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Military_base.db";
    public static final String TABLE_NAME = "Personnel_table";
    public static final String ID = "ID";
    public static final String FIRST_NAME = "First Name";
    public static final String LAST_NAME = "Last Name";
    public static final String PASSWORD = "Password";
    public static final String RANK = "Rank";
    public static final String STATUS = "Status";

    public DatabaseHelperClass(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db;
       /* db = this.getWritableDatabase(); */
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGERE PRIMARY KEY AUTOINCREMENT," + FIRST_NAME + " TEXT," + LAST_NAME + " TEXT," + PASSWORD + " TEXT," + RANK + " TEXT," + STATUS + " Text)");
    }

    //Remove,Add,Delete and create table.
    // and use Select * from table

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
