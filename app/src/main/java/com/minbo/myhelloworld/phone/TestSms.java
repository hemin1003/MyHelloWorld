package com.minbo.myhelloworld.phone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.minbo.myhelloworld.R;

public class TestSms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sms);

        TextView myTextView = (TextView) findViewById(R.id.myTextView);
        myTextView.setText("正在等待接收短信...");

    }
}
