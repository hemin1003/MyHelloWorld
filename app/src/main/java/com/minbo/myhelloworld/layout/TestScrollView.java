package com.minbo.myhelloworld.layout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

import org.w3c.dom.Text;

public class TestScrollView extends AppCompatActivity {

    private Button btnHttpContent, btnFileContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scroll_view);

        btnHttpContent = (Button) findViewById(R.id.btnHttpContent);
        btnHttpContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestScrollView.this, TestHttpContent.class);
                startActivity(intent);
            }
        });

        btnFileContent = (Button) findViewById(R.id.btnFileContent);
        btnFileContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestScrollView.this, TestFileContent.class);
                startActivity(intent);
            }
        });

    }
}