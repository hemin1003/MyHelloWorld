package com.minbo.myhelloworld.layout;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.minbo.myhelloworld.R;

public class TestHttpContent extends AppCompatActivity {

    private ScrollView myScrollView;
    private LinearLayout myLinear;
    private ProgressDialog progressDialog;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_http_content);

        myScrollView = (ScrollView) findViewById(R.id.myScrollView);
        myLinear = (LinearLayout) findViewById(R.id.myLinear);

//        for (int i = 0; i < 3; i++) {
//            ImageView image = new ImageView(this);
//            image.setBackgroundColor(Color.BLUE);
//            image.setImageResource(R.mipmap.bg01);
//            myLinear.addView(image);
//        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("提示");
        progressDialog.setMessage("Loading...");

        try{

            String path = "http://58.67.219.248/besthainan-web/wechat/a.html";
            String result = (String)(new MyAsync().execute(path).get());
            textView = new TextView(this);
            //设置过滤点html标签显示
            textView.setText(Html.fromHtml(result));
            myLinear.addView(textView);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    class MyAsync extends AsyncTask {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {
            System.out.println("params[0]=" + params[0]);
            // 设置访问的Web站点
            String result = HttpUtils.sendHttpClientPost((String) params[0], null, "utf-8");
            return result;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            progressDialog.dismiss();
        }
    }
}
