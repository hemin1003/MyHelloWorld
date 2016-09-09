package com.minbo.myhelloworld;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.RemoteException;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockPackageManager;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class TestContentProvider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_content_provider);

        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        Log.i("version", "当前android api版本号=" + currentapiVersion + "");

        this.getVersion();

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

    private void showDetails(){
        ContentResolver resolver = getContentResolver();
        Cursor c = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        for (c.moveToFirst();(!c.isAfterLast());c.moveToNext()){
            //if (c.moveToFirst()){
            //取联系人姓名
            int nameIndex = c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            Log.i("contact:name", c.getString(nameIndex));
            //查联系人手机号码
            String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor c2 = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
            while(c2.moveToNext()){
                String phone = c2.getString(c2.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Log.i("contact:phone", phone);

            }
        }
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
        this.showDetails();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Denied
                    Toast.makeText(TestContentProvider.this, "WRITE_CONTACTS Granted", Toast.LENGTH_SHORT)
                            .show();
                    // Permission Granted
                    this.showDetails();
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


//    //    private static final String TAG = "Contacts";
//    private void insertDummyContact() {
//        // Two operations are needed to insert a new contact.
//        ArrayList<ContentProviderOperation> operations = new ArrayList<ContentProviderOperation>(2);
//
//        // First, set up a new raw contact.
//        ContentProviderOperation.Builder op =
//                ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
//                        .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
//                        .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null);
//        operations.add(op.build());
//
//        // Next, set the name for the contact.
//        op = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
//                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
//                .withValue(ContactsContract.Data.MIMETYPE,
//                        ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
//                .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,
//                        "__DUMMY CONTACT from runtime permissions sample");
//        operations.add(op.build());
//
//        // Apply the operations.
//        ContentResolver resolver = getContentResolver();
//        try {
//            resolver.applyBatch(ContactsContract.AUTHORITY, operations);
//        } catch (RemoteException e) {
//            Log.d(TAG, "Could not add a new contact: " + e.getMessage());
//        } catch (OperationApplicationException e) {
//            Log.d(TAG, "Could not add a new contact: " + e.getMessage());
//        }
//    }

}