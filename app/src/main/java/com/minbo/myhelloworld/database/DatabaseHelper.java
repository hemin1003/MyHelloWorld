package com.minbo.myhelloworld.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/7.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "myDataBase";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context){
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TABLE_NAME + " (name text not null, age text not null ) ";
        Log.i("hemin:createDB=" , sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
