package com.minbo.myhelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TestSms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sms);

        TextView myTextView = (TextView) findViewById(R.id.myTextView);
        myTextView.setText("正在等待接收短信...");

    }
}
