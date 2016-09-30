package com.minbo.myhelloworld.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.minbo.myhelloworld.R;

import java.io.IOException;
import java.io.InputStream;

public class TestFileContent extends AppCompatActivity {

    private ScrollView myScrollView;
    private LinearLayout myLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_file_content);

        myScrollView = (ScrollView) findViewById(R.id.myScrollView);
        myLinear = (LinearLayout) findViewById(R.id.myLinear);

        try {
            //Return an AssetManager instance for your application's package
            InputStream is = getAssets().open("term_of_service.html");
            int size = is.available();

            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the buffer into a string.
            String text = new String(buffer, "utf-8");

            TextView textView = new TextView(this);

            //设置过滤点html标签显示
            textView.setText(Html.fromHtml(text));
            myLinear.addView(textView);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
