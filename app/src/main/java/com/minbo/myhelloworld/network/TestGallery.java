package com.minbo.myhelloworld.network;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

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
                Log.i("dailog", "99999999999999999999");
                new AlertDialog.Builder(TestGallery.this)
                        .setTitle("提示")
                        .setMessage("hello dialog")
                        .setNegativeButton("确定", new  DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(TestGallery.this, "点击我了", Toast.LENGTH_SHORT).show();
                            }
                        });

                //System.out.print(Environment.getExternalStorageDirectory().getAbsolutePath());

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
