package com.minbo.myhelloworld;

import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TestLinkfy extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_linkfy);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        editText =  (EditText) findViewById(R.id.editText);

        editText.setOnKeyListener(new EditText.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                textView1.setText(editText.getText());
                Linkify.addLinks(textView1, Linkify.ALL);
                return false;
            }
        });
    }
}
