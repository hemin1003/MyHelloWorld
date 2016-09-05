package com.minbo.myhelloworld;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (TextView) findViewById(R.id.textView2);
        t.setText("hemin123");
        t.setBackgroundColor(Color.GREEN);

        Button b = (Button) findViewById(R.id.button);
        ButtonListener listener = new ButtonListener();
        b.setOnClickListener(listener);
    }

    class ButtonListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            count++;
            t.setText(count + "");
            Toast.makeText(MainActivity.this, "count=" + count, Toast.LENGTH_SHORT).show();
        }
    }
}
