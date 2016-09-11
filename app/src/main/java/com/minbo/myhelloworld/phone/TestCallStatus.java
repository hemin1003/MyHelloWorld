package com.minbo.myhelloworld.phone;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import com.minbo.myhelloworld.R;

import org.w3c.dom.Text;

public class TestCallStatus extends AppCompatActivity {

    TextView myTextViewInfo;
    TextView myTextViewInfo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_call_info);

        myTextViewInfo = (TextView) findViewById(R.id.myTextViewInfo);
        myTextViewInfo2 = (TextView)findViewById(R.id.myTextViewInfo2);

        MyPhoneCallListener myCall = new MyPhoneCallListener();
        TelephonyManager tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(myCall, PhoneStateListener.LISTEN_CALL_STATE);
    }

    class MyPhoneCallListener extends PhoneStateListener{
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state){
                case TelephonyManager.CALL_STATE_IDLE:
                    myTextViewInfo.setText("空闲");
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    myTextViewInfo.setText("接起电话");
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    myTextViewInfo.setText("电话进线");
                    getContactPeople(incomingNumber);
                    break;
            }
            super.onCallStateChanged(state, incomingNumber);
        }
    }

    private void getContactPeople(String incomingNumber){
//        ContentResolver cr = getContentResolver();
//        Cursor c = null;
//        String []  projection = new String[]{Contacts.People._ID, Contacts.People.NAME, Contacts.People.NUMBER};
//        c = cr.query(ContactsContract.Contacts.CONTENT_URI, projection,
//                Contacts.People.NUMBER + "=?", new String[]{incomingNumber},
//                ContactsContract.Contacts.DISPLAY_NAME_SOURCE);
//        if(c.getCount() == 0){
//            myTextViewInfo2.setText("Unknow number=" + incomingNumber);
//
//        }else if(c.getCount() > 0){
//            c.moveToFirst();
//            String name = c.getString(1);
//            myTextViewInfo2.setText(name + ":" + incomingNumber);
//        }
    }
}
