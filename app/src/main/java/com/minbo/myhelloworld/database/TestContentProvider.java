package com.minbo.myhelloworld.database;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.minbo.myhelloworld.R;
import com.minbo.myhelloworld.network.TestNetwork;

public class TestContentProvider extends AppCompatActivity {

    private TelephonyManager telMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_content_provider);

        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        Log.i("version", "当前android api版本号=" + currentapiVersion + "");

        this.getVersion();

        telMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        if(currentapiVersion>22) {
            this.myRequestPermission();

        }else{
            this.showDetails();
        }
    }

    /**
     * 获取版本号
     * @return 当前应用的版本号
     */
    public void getVersion() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            Log.i("version", "当前应用的版本号=" + version + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showDetail2(){
        Toast.makeText(this, "you have the permission", Toast.LENGTH_SHORT).show();
        // you have the permission
        Toast.makeText(TestContentProvider.this, "Line1Number=" + telMgr.getLine1Number()
                + ", NetworkOperatorName=" + telMgr.getNetworkOperatorName(), Toast.LENGTH_SHORT).show();
    }

    private void showDetails(){
        ContentResolver cr = this.getContentResolver();
        String bluetooth = android.provider.Settings.System.getString(cr, Settings.Global.BLUETOOTH_ON);
        String wifi = android.provider.Settings.System.getString(cr, Settings.Global.WIFI_ON);
        String airplane = android.provider.Settings.System.getString(cr, Settings.Global.AIRPLANE_MODE_ON);
        String dataRoaming = android.provider.Settings.System.getString(cr, Settings.Global.DATA_ROAMING);

        Toast.makeText(TestContentProvider.this, "Line1Number=" + telMgr.getLine1Number()
                        + ", NetworkOperatorName=" + telMgr.getNetworkOperatorName()
                        + ", 蓝牙状态bluetooth=" + bluetooth
                        + ", wifi=" + wifi
                        + "，飞行模式airplane=" + airplane
                        + ", 数据漫游dataRoaming=" + dataRoaming
                , Toast.LENGTH_LONG).show();

//        ContentResolver resolver = getContentResolver();
//        Cursor c = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
//        for (c.moveToFirst();(!c.isAfterLast());c.moveToNext()){
//            //if (c.moveToFirst()){
//            //取联系人姓名
//            int nameIndex = c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
//            Log.i("contact:name", c.getString(nameIndex));
//            //查联系人手机号码
//            String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
//            Cursor c2 = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
//                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
//            while(c2.moveToNext()){
//                String phone = c2.getString(c2.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                Log.i("contact:phone", phone);
//
//            }
//        }
    }

    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    @TargetApi(23)
    private void myRequestPermission() {
        int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.WRITE_CONTACTS);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {Manifest.permission.WRITE_CONTACTS},
                    REQUEST_CODE_ASK_PERMISSIONS);
            return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(TestContentProvider.this, "WRITE_CONTACTS Granted", Toast.LENGTH_SHORT)
                            .show();
                    // Permission Granted
                    this.showDetail2();

                } else {
                    // Permission Denied
                    Toast.makeText(TestContentProvider.this, "WRITE_CONTACTS Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}