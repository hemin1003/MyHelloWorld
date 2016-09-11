package com.minbo.myhelloworld.privilege;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/11.
 * 参考类：database/TestContentProvider
 */
@TargetApi(23)
public class PrivilegeUtils  extends AppCompatActivity {

    final private int REQUEST_CODE_ASK_PERMISSIONS = 0;

    private void requestPermission(int REQUEST_CODE_ASK_PERMISSIONS) {
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
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
                    // Permission Denied
                    Toast.makeText(PrivilegeUtils.this, "WRITE_CONTACTS Granted", Toast.LENGTH_SHORT)
                            .show();
                    // Permission Granted
                    //this.showDetails();
                } else {
                    // Permission Denied
                    Toast.makeText(PrivilegeUtils.this, "WRITE_CONTACTS Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
