package com.example.danielmsibi.recipeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by NWUUser on 2016/10/13.
 */
public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "admin.db";
    private static final String TABLE_NAME= "admin";
    private static final String COLUM_ID = "id";
    private static final String COLUM_FNAME = "fname";
    private static final String COLUM_LNAME = "lname";
    private static final String COLUM_EMAIL = "email";
    private static final String COLUM_PASS = "pass";
    private static final String COLUM_UNAME = "uname" ;


    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table admin(id integer primary key not null auto_increment,"+
            "fname text not null,lname text not null,email text not null, pass text not null";


            public Database(Context context)
            {
                super(context,DATABASE_NAME,null,DATABASE_VERSION);
            }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      String quer = "DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(quer);
        this.onCreate(db);
    }

    public String searchPas(String uName)
    {
        db = this.getReadableDatabase();
        String query = "select uname,pass from admin";
        Cursor cursor = db.rawQuery(query, null);
        String s , b;

        b= "not found";
        if(cursor.moveToFirst())
        {
            do{
               s=cursor.getString(0);


                if(s.equals(uName))
                {
                    b =cursor.getString(1);
                    break;}


            }while (cursor.moveToNext());
        }
            return b;
    }
    public void addInformation(String name, String last_name,String user_name, String email, String password,SQLiteDatabase db )
    {
        ContentValues contentValues= new ContentValues();
        contentValues.put(COLUM_FNAME,name);
        contentValues.put(COLUM_LNAME,last_name);
        contentValues.put(COLUM_UNAME,user_name);
        contentValues.put(COLUM_EMAIL,email);
        contentValues.put(COLUM_PASS,password);
        db.insert(TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS","One row inserted ...");
    }
}
