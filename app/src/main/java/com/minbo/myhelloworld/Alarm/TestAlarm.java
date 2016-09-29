package com.minbo.myhelloworld.Alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

import java.util.Calendar;

public class TestAlarm extends AppCompatActivity {

    private Button btnSet, btnCancel;
    private AlarmManager alarmManager;
    Calendar mCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_alarm);
        //获取AlarmManager对象
        alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);

        btnSet = (Button) findViewById(R.id.btnSet);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestAlarm.this, "设置闹钟", Toast.LENGTH_SHORT).show();

            }
        });

        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestAlarm.this, "取消闹钟", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
