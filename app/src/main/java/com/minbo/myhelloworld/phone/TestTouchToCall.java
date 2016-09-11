package com.minbo.myhelloworld.phone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.minbo.myhelloworld.R;

public class TestTouchToCall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_call);

        Button btn_callNum = (Button) findViewById(R.id.btn_callNum);
        btn_callNum.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myDial = new Intent("android.intent.action.CALL_BUTTON");
                startActivity(myDial);
            }
        });
    }
}
