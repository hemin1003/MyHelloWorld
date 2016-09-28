package com.iflytek.viewpagerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iflytek.viewpagerdemo.TabLayout.TestTabLayout;
import com.iflytek.viewpagerdemo.initialpage.SharedHelper;
import com.iflytek.viewpagerdemo.initialpage.TestInitialPage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myBtn = (Button) findViewById(R.id.myBtn);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestViewPager.class);
                startActivity(intent);
            }
        });

        Button myTabLayout = (Button) findViewById(R.id.myTabLayout);
        myTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestTabLayout.class);
                startActivity(intent);
            }
        });

        final SharedHelper sh = new SharedHelper(this, "initialFlag");
        Button myInitialPage = (Button) findViewById(R.id.myInitialPage);
        myInitialPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sh.getValue("initial")==null){
                    sh.putValue("initial", "1");
                    Intent intent = new Intent(MainActivity.this, TestInitialPage.class);
                    startActivity(intent);
                    
                }else{
                    Toast.makeText(MainActivity.this, "已经点击过了.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
