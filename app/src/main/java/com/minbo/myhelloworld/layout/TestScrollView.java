package com.minbo.myhelloworld.layout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.minbo.myhelloworld.R;

public class TestScrollView extends AppCompatActivity {

    private ScrollView myScrollView;
    private LinearLayout myLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scroll_view);

        myScrollView = (ScrollView) findViewById(R.id.myScrollView);
        myLinear = (LinearLayout) findViewById(R.id.myLinear);

//        for (int i = 0; i < 3; i++) {
//            ImageView image = new ImageView(this);
//            image.setBackgroundColor(Color.BLUE);
//            image.setImageResource(R.mipmap.bg01);
//            myLinear.addView(image);
//        }


        TextView view = new TextView(this);
        view.setText("hello");
        myLinear.addView(view);
    }
}
