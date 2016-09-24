package com.minbo.myhelloworld.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

public class TestBroadCast extends AppCompatActivity {
    private MyBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_broad_cast);

        Button btn_addBroadCast = (Button) findViewById(R.id.btn_addBroadCast);
        btn_addBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(receiver==null){
                    receiver = new MyBroadcastReceiver();
                    IntentFilter filter = new IntentFilter();
                    filter.addAction("android.intent.action.MyBroadcastReceiver");
                    registerReceiver(receiver, filter);
                    
                }else{
                    Toast.makeText(TestBroadCast.this, "广播已注册", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        Button btn_cancelBroadCast = (Button) findViewById(R.id.btn_cancelBroadCast);
        btn_cancelBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(receiver!=null){
                    unregisterReceiver(receiver);
                }else{
                    Toast.makeText(TestBroadCast.this, "广播已取消注册", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btn_Uninstall = (Button) findViewById(R.id.btn_Uninstall);
        btn_Uninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 卸载应用
                Uri uninstallUri = Uri.fromParts("package", "com.minbo.testdemo", null);
                Intent intent = new Intent(Intent.ACTION_DELETE, uninstallUri);
                startActivity(intent);
            }
        });
    }
}
