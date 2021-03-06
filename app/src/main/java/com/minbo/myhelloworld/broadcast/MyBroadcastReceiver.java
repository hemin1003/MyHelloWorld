package com.minbo.myhelloworld.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public MyBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg=intent.getExtras().get("msg").toString();
        Toast.makeText(context,"intent.getAction()"+intent.getAction().toString(),
                Toast.LENGTH_LONG).show();
        System.out.println("msg:"+msg);
    }
}
