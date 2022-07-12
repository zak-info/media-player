package com.example.tp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "tp1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table login(name TEXT,email TEXT,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists login");
    }
    public Boolean insert_Login(String name, String email,String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name );
        contentValues.put("email",email );
        contentValues.put("password",password );
        long result=DB.insert("login", null, contentValues);
        if (result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor get_Login () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from login", null);
        return cursor;

    }
}

