package com.minbo.myhelloworld.handle;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.minbo.myhelloworld.R;

public class TestHandle extends AppCompatActivity implements View.OnClickListener {

    private TextView text1;
    private Button btn_Handle;
    private MyHandle handle;
    private MyHandle2 handle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_handle);
        btn_Handle = (Button) findViewById(R.id.btn_Handle);
        btn_Handle.setOnClickListener(this);
        text1 = (TextView) findViewById(R.id.text1);
    }

    @Override
    public void onClick(View v) {
        Log.i("通知thread_id:", ""+Thread.currentThread().getId());
//        //创建一个包含Looper的线程，这里如果没有HandlerThread的调用，会直接将后边的MyThread放到UI线程队列
//        HandlerThread myHandleThread = new HandlerThread("hemin");
//        //启动新线程
//        myHandleThread.start();

        //将handler绑定到新线程
        handle = new MyHandle();
        handle2 = new MyHandle2();

        //执行任务
        handle.post(new MyThread());
        handle2.post(new MyThread2());
    }

    class MyHandle extends Handler{

//        public MyHandle(Looper looper){
//            super(looper);
//        }

        @Override
        public void handleMessage(Message msg) {
            int whatNumber = msg.what;
            Bundle bundle = (Bundle)msg.obj;
            Log.i("what", whatNumber+"");
//            Log.i("名称", bundle.getString("name"));
//            Log.i("年龄", bundle.getInt("age")+"");
//            text1.setText(bundle.getString("name") + ", " + bundle.getInt("age"));
            super.handleMessage(msg);
        }
    }

    class MyThread implements Runnable{
        @Override
        public void run() {
            try {
                Message message = Message.obtain(handle);
                message.what = 10;
                Bundle bundle = new Bundle();
                bundle.putString("name", "zhangsan");
                bundle.putInt("age", 20);
                message.obj = bundle;
                Log.i("通知111", "开始发message了哦");
                Log.i("通知111thread_id:", ""+Thread.currentThread().getId());
                message.sendToTarget();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    class MyHandle2 extends Handler{

//        public MyHandle2(Looper looper){
//            super(looper);
//        }

        @Override
        public void handleMessage(Message msg) {
            int whatNumber = msg.what;
            Bundle bundle = (Bundle)msg.obj;
            Log.i("what", whatNumber+"");
//            Log.i("名称", bundle.getString("name"));
//            Log.i("年龄", bundle.getInt("age")+"");
//            text1.setText(bundle.getString("name") + ", " + bundle.getInt("age"));
            super.handleMessage(msg);
        }
    }

    class MyThread2 implements Runnable{
        @Override
        public void run() {
            try {
                Message message = Message.obtain(handle);
                message.what = 40;
                Bundle bundle = new Bundle();
                bundle.putString("name", "lisi");
                bundle.putInt("age", 50);
                message.obj = bundle;
                Log.i("通知222", "开始发message了哦");
                Log.i("通知222thread_id:", ""+Thread.currentThread().getId());
                message.sendToTarget();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
