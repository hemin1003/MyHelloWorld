package com.minbo.myhelloworld.phone;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

public class TestSmsStatus extends AppCompatActivity {

    private MyService service1, service2;
    private Button btn_Send;

    private static final String SMS_SEND_ACTION = "99";
    private static final String SMS_DELIVERED_ACTION = "88";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sms_status);

        btn_Send = (Button) findViewById(R.id.btn_Send);
        btn_Send.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                SmsManager sms = SmsManager.getDefault();

                Intent send = new Intent(SMS_SEND_ACTION);
                Intent deliver = new Intent(SMS_DELIVERED_ACTION);

                PendingIntent pSend = PendingIntent.getBroadcast(getApplicationContext(), 0, send, 0);
                PendingIntent pDeliver = PendingIntent.getBroadcast(getApplicationContext(), 0, deliver, 0);

                sms.sendTextMessage("18688200527", null, "HelloWorld", pSend, pDeliver);
                Toast.makeText(TestSmsStatus.this, "正在发送sms...", Toast.LENGTH_SHORT).show();

            }
        });
    }

    class MyService extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.i("sms getResultCode()=", String.valueOf(getResultCode()));
            switch (getResultCode()){
                case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                    Toast.makeText(TestSmsStatus.this, "发送失败.", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(TestSmsStatus.this, "发送成功.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    @Override
    protected void onResume() {
        IntentFilter mFilter1 = new IntentFilter(SMS_SEND_ACTION);
        service1 = new MyService();
        registerReceiver(service1, mFilter1);

        IntentFilter mFilter2 = new IntentFilter(SMS_DELIVERED_ACTION);
        service2 = new MyService();
        registerReceiver(service2, mFilter2);

        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(service1);
        unregisterReceiver(service2);

        super.onPause();
    }
}
