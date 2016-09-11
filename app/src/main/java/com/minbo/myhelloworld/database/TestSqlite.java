package com.minbo.myhelloworld.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.minbo.myhelloworld.R;

public class TestSqlite extends AppCompatActivity {

    private DatabaseHelper myDbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sqlite);

        Button btn_insertData = (Button) findViewById(R.id.btn_insertData);
        btn_insertData.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //只会在第一次使用SQLiteDatabase才会创建表
                SQLiteDatabase db = myDbHelper.getWritableDatabase();
                String sql = "insert into " + DatabaseHelper.TABLE_NAME + " values('张三','100');";
                String sql2 = "insert into " + DatabaseHelper.TABLE_NAME + " values('李四','500');";
                db.execSQL(sql);
                db.execSQL(sql2);
                Log.i("hemin:insertSql=", sql);
                Log.i("hemin:insertSql=", sql2);
                setTitle("成功插入两条数据.");
            }
        });

        Button btn_queryData = (Button) findViewById(R.id.btn_queryData);
        btn_queryData.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDbHelper.getReadableDatabase();
                String col[] = {"name", "age"};
                Cursor cur = db.query(DatabaseHelper.TABLE_NAME, col, null, null, null, null, null);
                int i = cur.getCount();
                setTitle(i + " 条记录.");
            }
        });

        Button btn_deleteData = (Button)findViewById(R.id.btn_deleteData);
        btn_deleteData.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDbHelper.getWritableDatabase();
                db.delete(DatabaseHelper.TABLE_NAME, " name='张三' " , null);
                setTitle("删除了name='张三'的一条记录.");
            }
        });

        Button btn_dropTable = (Button)findViewById(R.id.btn_dropTable);
        btn_dropTable.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDbHelper.getWritableDatabase();
                String sql = "drop table " + DatabaseHelper.TABLE_NAME;
                db.execSQL(sql);
                setTitle("成功删除了数据库表=" + DatabaseHelper.TABLE_NAME);
            }
        });

        Button btn_createTable = (Button)findViewById(R.id.btn_createTable);
        btn_createTable.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDbHelper.getWritableDatabase();
                String sql = "create table " + DatabaseHelper.TABLE_NAME + " (name text not null, age text not null ) ";
                Log.i("hemin:createDB=" , sql);
                db.execSQL(sql);
                setTitle("重建表成功.");
            }
        });
    }
}
