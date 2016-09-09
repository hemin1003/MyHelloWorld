package com.minbo.myhelloworld;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class TestBattery extends AppCompatActivity {

    private int intLevel;
    private int intScale;
    private Button btn_getBattery;

    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(Intent.ACTION_BATTERY_CHANGED.equals(action)){
                intLevel = intent.getIntExtra("level", 0);
                intScale = intent.getIntExtra("scale", 100);
                onBatteryInfoReceiver(intLevel, intScale);
            }
        }
    };

    private void onBatteryInfoReceiver(int intLevel, int intScale){
        final Dialog d = new Dialog(TestBattery.this);
        d.setTitle(R.string.dialog_title);
        d.setContentView(R.layout.mydialog);
        Window win = d.getWindow();
        win.setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, WindowManager.LayoutParams.FLAG_BLUR_BEHIND);

        TextView myTextView2 = (TextView) findViewById(R.id.myTextView2);
//        myTextView2.setText(getResources().getText(R.string.dialog_body)
//                + String.valueOf(intLevel*100/intScale) + "%");

        myTextView2.setText(String.valueOf(intLevel*100/intScale) + "%");

        Button myButton2 = (Button)findViewById(R.id.myButton2);
        myButton2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                unregisterReceiver(myReceiver);
            }
        });
        d.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_battery);
        btn_getBattery = (Button) findViewById(R.id.btn_getBattery);
        btn_getBattery.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //注册服务
                registerReceiver(myReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            }
        });
    }
}
