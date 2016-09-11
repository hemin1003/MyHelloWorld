package com.minbo.myhelloworld.internet_demo;

import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.minbo.myhelloworld.R;

import java.io.File;
import java.io.FileReader;

public class TestGallery extends AppCompatActivity {

    private Button myBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_gallery);

        myBtn = (Button) findViewById(R.id.myBtn);
        myBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                System.out.print(Environment.getExternalStorageDirectory().getAbsolutePath());

//                try{
//                    FileReader reader = new FileReader(new File("/mnt/sdcard/test.txt"));
//                    int ch = 0;
//                    while((ch=reader.read())!=-1){
//                        System.out.print((char)ch);
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
            }
        });
    }


}
