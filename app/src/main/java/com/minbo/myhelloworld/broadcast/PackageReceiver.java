package com.minbo.myhelloworld.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class PackageReceiver extends BroadcastReceiver {
    public PackageReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //区分接收到的是哪种广播
        String action = intent.getAction();
        //获取广播中包含的应用包名
        Uri uri = intent.getData();
        if(action.equals("android.intent.action.PACKAGE_ADDED")){
            System.out.println(uri + "被安装了");
        }
        else if(action.equals("android.intent.action.PACKAGE_REPLACED")){
            System.out.println(uri + "被更新了");
        }
        else if(action.equals("android.intent.action.PACKAGE_REMOVED")){
            System.out.println(uri + "被卸载了");
        }
    }
}
