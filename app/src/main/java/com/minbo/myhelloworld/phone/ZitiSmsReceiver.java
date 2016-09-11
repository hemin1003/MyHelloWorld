package com.minbo.myhelloworld.phone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import com.minbo.myhelloworld.phone.TestSms;

/**
 * Created by Administrator on 2016/9/8.
 */
public class ZitiSmsReceiver extends BroadcastReceiver {



    private static final String mAction = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(mAction)){
            StringBuilder sb = new StringBuilder();
            Bundle bundle = intent.getExtras();
            if(bundle!=null){
                Object[] myObjs = (Object[])bundle.get("pdus");
                SmsMessage[] messages = new SmsMessage[myObjs.length];
                for (int i=0; i<myObjs.length; i++){
                    messages[i] = SmsMessage.createFromPdu((byte[]) myObjs[i]);
                }
                for (SmsMessage message : messages){
                    sb.append("接收到来自：");
                    sb.append(message.getDisplayOriginatingAddress());
                    sb.append("\n---------传来的短信---------");
                    sb.append(message.getDisplayMessageBody());
                }
                Toast.makeText(context, sb.toString(), Toast.LENGTH_LONG).show();
                Intent i = new Intent(context, TestSms.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        }
    }
}
