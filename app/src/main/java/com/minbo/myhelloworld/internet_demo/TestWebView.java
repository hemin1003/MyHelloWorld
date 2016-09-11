package com.minbo.myhelloworld.internet_demo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

import java.net.URL;

public class TestWebView extends AppCompatActivity {

    private EditText myEditText;
    private Button btn_Go;
    private Button btn_GoGO;
    private WebView myWebView;
    private WebView myWebView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_web_view);

        myEditText = (EditText) findViewById(R.id.myEditText);
        btn_Go = (Button) findViewById(R.id.btn_Go);
        btn_GoGO = (Button)findViewById(R.id.btn_GoGO);
        myWebView = (WebView)findViewById(R.id.myWebView);
        myWebView2 = (WebView)findViewById(R.id.myWebView2);

        btn_Go.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                String url = myEditText.getText().toString();
                myWebView.loadUrl(url);
                Toast.makeText(TestWebView.this, "url=" + url, Toast.LENGTH_LONG).show();

                myWebView2.loadData("<html>" +
                            "<body>aaaaaaaaaaaaaaaaaa" +
                                "<a href='#'>www.baidu.com</a>" +
                                "<img src='http://192.168.0.101:8080/besthainan-web/wechat/photos/photograph-4.jpg'/>" +
                            "</body>" +
                        "</html>", "text/html", "utf-8");
            }
        });

        btn_GoGO.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                goToUrl();
            }
        });
    }

    private void goToUrl(){
        Uri uri = Uri.parse("http://192.168.0.101:8080/besthainan-web/wechat/aylson.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
