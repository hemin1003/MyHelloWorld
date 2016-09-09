package com.minbo.myhelloworld;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class TestNetwork extends AppCompatActivity {

    final private int REQUEST_CODE_READ_SMS = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_network);

        TelephonyManager telMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        Log.i("version", "TestNetwork 当前android api版本号=" + currentapiVersion + "");

        if(currentapiVersion>22) {
            // Assume thisActivity is the current activity
            int permissionCheck = ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_SMS);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_SMS},
                        REQUEST_CODE_READ_SMS); // define this constant yourself
            } else {
                // you have the permission
                Toast.makeText(TestNetwork.this, "Line1Number=" + telMgr.getLine1Number()
                        + ", NetworkOperatorName=" + telMgr.getNetworkOperatorName(), Toast.LENGTH_SHORT).show();
            }
        }else{
            ContentResolver cr = this.getContentResolver();
            String bluetooth = android.provider.Settings.System.getString(cr, Settings.Global.BLUETOOTH_ON);
            String wifi = android.provider.Settings.System.getString(cr, Settings.Global.WIFI_ON);
            String airplane = android.provider.Settings.System.getString(cr, Settings.Global.AIRPLANE_MODE_ON);
            String dataRoaming = android.provider.Settings.System.getString(cr, Settings.Global.DATA_ROAMING);

            Toast.makeText(TestNetwork.this, "Line1Number=" + telMgr.getLine1Number()
                    + ", NetworkOperatorName=" + telMgr.getNetworkOperatorName()
                    + ", 蓝牙状态bluetooth=" + bluetooth
                    + ", wifi=" + wifi
                    + "，飞行模式airplane=" + airplane
                    + ", 数据漫游dataRoaming=" + dataRoaming
                    , Toast.LENGTH_LONG).show();

        }
    }
}
