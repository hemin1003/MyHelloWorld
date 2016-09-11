package com.minbo.myhelloworld.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.minbo.myhelloworld.R;

/**
 * Created by Administrator on 2016/9/7.
 * 使用SharedPreferences存储
 */
public class TestShared extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_shared);

        SharedHelper sh = new SharedHelper(this, "contacts");
        sh.putValue("name", "贺敏");;
        sh.putValue("age", "100");

        String name = sh.getValue("name");
        String age = sh.getValue("age");

        TextView myTextView = (TextView) findViewById(R.id.myTextView);

        System.out.println("name=" + name + "\n age=" + age);
        myTextView.setText("name=" + name + "\n age=" + age);
    }
}
