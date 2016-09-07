package com.minbo.myhelloworld;

import android.app.Service;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class TestVibrate extends AppCompatActivity {

    private Vibrator myVibrator;
    ToggleButton myToggleButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_vibrate);

        myVibrator = (Vibrator) getApplication().getSystemService(Service.VIBRATOR_SERVICE);
        myToggleButton1 = (ToggleButton) findViewById(R.id.myToggleButton1);

        myToggleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myToggleButton1.isChecked()){
                    myVibrator.vibrate(2000);
                    Toast.makeText(TestVibrate.this, "震动啦啦啦啦1111", Toast.LENGTH_SHORT).show();
                }else{
                    myVibrator.cancel();
                    Toast.makeText(TestVibrate.this, "取消震动啦啦2222", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
