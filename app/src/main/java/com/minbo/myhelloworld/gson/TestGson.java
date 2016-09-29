package com.minbo.myhelloworld.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.minbo.myhelloworld.R;
import com.minbo.myhelloworld.gson.javabean.User;

public class TestGson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_gson);

        Button myBtn = (Button) findViewById(R.id.myBtn);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                User user = new User("小明", true, 16, "中国xxxxxxxxxx");;
                Toast.makeText(TestGson.this, "" + gson.toJson(user),
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button myBtn2 = (Button) findViewById(R.id.myBtn2);
        myBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = "{\"name\":\"小明\",\"sex\":true,\"age\":16,\"homeAddress\":\"中国xxxxxxxxxx\"}";
                Gson gson = new Gson();
                User user = gson.fromJson(json, User.class);
                Toast.makeText(TestGson.this, "" + user.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
