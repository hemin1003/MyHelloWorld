package com.minbo.myhelloworld;



import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.minbo.myhelloworld.database.TestContentProvider;
import com.minbo.myhelloworld.database.TestShared;
import com.minbo.myhelloworld.database.TestSqlite;
import com.minbo.myhelloworld.fragment.TestFragment;
import com.minbo.myhelloworld.layout.TestLinearLayout;
import com.minbo.myhelloworld.network.TestGallery;
import com.minbo.myhelloworld.network.TestNetwork;
import com.minbo.myhelloworld.network.TestWebView;
import com.minbo.myhelloworld.phone.TestBattery;
import com.minbo.myhelloworld.phone.TestSms;
import com.minbo.myhelloworld.phone.TestSmsStatus;
import com.minbo.myhelloworld.phone.TestTouchToCall;
import com.minbo.myhelloworld.phone.TestCallStatus;
import com.minbo.myhelloworld.phone.TestVibrate;
import com.minbo.myhelloworld.widget.TestDailog;
import com.minbo.myhelloworld.widget.TestImageView;
import com.minbo.myhelloworld.widget.TestLinkfy;
import com.minbo.myhelloworld.widget.TestSpinner;

/** Android Study Plan
 //        1. 相对布局
 //        2. Intent
 //        3. Service
 //        4. Handle
 //        5. Fragment
 //        6. 常用功能实现
 //          a. APP图标
 //          b. 引导页
 //          c. 动态图或者视频显示
 //          d. 菜单侧滑
 //          e. 图片轮播
 //          f. 下拉刷新、上拉加载
 //          g. 应用监控
 //          h. 应用签名
 //          i. 应用安全
 //          j. 在线更新
 //          k. SDCard操作
 //          m. 手势密码
 //          n. 百度地图
 //        7. 常用Android API使用（如取联系人, 取短信, 打电话, 发邮件, 播放音乐等）
 //        8. 常用第三方库使用（如gson, fastjson, 图标, okhttp等）
 */
public class MainActivity extends AppCompatActivity {
    private int count = 0;
    private TextView t;
    private EditText et;
    private TextView tv;
    private CheckBox cbPlain;
    private CheckBox cbSerif;
    private TextView showCbValue;
    private RadioGroup rgMenu;

    RadioButton radio_man;
    RadioButton radio_female;
    TextView textView11;

    TextView tv_input3;
    CheckBox cb_A2;
    CheckBox cb_B2;
    CheckBox cb_C2;

    ImageView imageView1;
    ImageView imageView2;

    EditText keyword_et;
    TextView result_tv;
    TextView myTextView12;

    Button myButton13;
    ProgressBar myProgresBar;
    TextView myTextView13;
    int intCounter = 0;
    Handler myMessageProgress;

    int dYear,dMonth,dDay,dHour,dMin;
    TextView myTextView14;
    DatePicker myDatePicker;
    TimePicker myTimePicker;

    Button button15;
    Button button16;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 0, 0, "显示Button15");
        menu.add(0, 1, 0, "显示Button16");
        menu.findItem(0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0:
                this.clickItem1();
                break;
            case 1:
                this.clickItem2();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void clickItem1(){
        setTitle("button15可见");
        button15.setVisibility(View.VISIBLE);
        button16.setVisibility(View.INVISIBLE);
    }

    private void clickItem2(){
        setTitle("button16可见");
        button16.setVisibility(View.VISIBLE);
        button15.setVisibility(View.INVISIBLE);
    }

    private Button btn_toast;
    private Button btn_spinner;

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
//      super.onBackPressed();
        //这个方法是在返回键按下时，调用，其内部实际也是调用了finish()方法；
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //第十种，十一
        //setContentView(R.layout.main_list);

        /**
         * 全屏显示
         */
        /***
         * 这是隐藏标题栏
         */
        //getSupportActionBar().hide();
        /***
         * 添加全屏显示的标识位,默认情况下，添加全屏标识位并不会将标题栏隐藏掉，
         * 所以在添加全屏标识位之前，我们已提前将标题栏予以隐藏
         */
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        /**
         * 取消全屏显示（注意：下面这一部分已注释掉了，看代码时，注意看）
         */
        /**
         * 这是显示标题栏
         * */
        //getSupportActionBar().show();
        /**
         * 这是清除全屏显示标识位
         */
        //getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //状态栏透明
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.main_toast);

        Log.i("MainActivity info","999");

        btn_toast = (Button) findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                setTitle("使用Toast");
                Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
            }
        });

        btn_spinner = (Button) findViewById(R.id.btn_spinner);
        btn_spinner.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestSpinner.class);
                startActivity(intent);
            }
        });

        Button btn_shared = (Button) findViewById(R.id.btn_shared);
        btn_shared.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestShared.class);
                startActivity(intent);
            }
        });

        Button btn_sqlite = (Button) findViewById(R.id.btn_sqlite);
        btn_sqlite.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestSqlite.class);
                startActivity(intent);
            }
        });

        Button btn_contentProvider = (Button) findViewById(R.id.btn_contentProvider);
        btn_contentProvider.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestContentProvider.class);
                startActivity(intent);
            }
        });

        Button btn_textLinkfy = (Button) findViewById(R.id.btn_textLinkfy);
        btn_textLinkfy.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestLinkfy.class);
                startActivity(intent);
            }
        });

        Button btn_textVibrate = (Button) findViewById(R.id.btn_textVibrate);
        btn_textVibrate.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestVibrate.class);
                startActivity(intent);
            }
        });

        Button btn_Call = (Button) findViewById(R.id.btn_Call);
        btn_Call.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestTouchToCall.class);
                startActivity(intent);
            }
        });

        Button btn_ImageView = (Button) findViewById(R.id.btn_ImageView);
        btn_ImageView.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestImageView.class);
                startActivity(intent);
            }
        });

        Button btn_LinearLayout = (Button) findViewById(R.id.btn_LinearLayout);
        btn_LinearLayout.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestLinearLayout.class);
                startActivity(intent);
            }
        });

        Button btn_Newwork = (Button) findViewById(R.id.btn_Newwork);
        btn_Newwork.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestNetwork.class);
                startActivity(intent);
            }
        });

        Button btn_Sms = (Button) findViewById(R.id.btn_Sms);
        btn_Sms.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestSms.class);
                startActivity(intent);
            }
        });

        Button btn_Battery = (Button) findViewById(R.id.btn_Battery);
        btn_Battery.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestBattery.class);
                startActivity(intent);
            }
        });

        Button btn_CallInfo = (Button) findViewById(R.id.btn_CallInfo);
        btn_CallInfo.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestCallStatus.class);
                startActivity(intent);
            }
        });

        Button btn_SmsStatus = (Button) findViewById(R.id.btn_SmsStatus);
        btn_SmsStatus.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestSmsStatus.class);
                startActivity(intent);
            }
        });

        Button btn_WebView = (Button) findViewById(R.id.btn_WebView);
        btn_WebView.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestWebView.class);
                startActivity(intent);
            }
        });

        Button btn_Gallery = (Button) findViewById(R.id.btn_Gallery);
        btn_Gallery.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestGallery.class);
                startActivity(intent);
            }
        });

        Button btn_Fragment = (Button) findViewById(R.id.btn_Fragment);
        btn_Fragment.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestFragment.class); startActivity(intent);
            }
        });

        Button btn_TestDailog = (Button) findViewById(R.id.btn_TestDailog);
        btn_TestDailog.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestDailog.class);
                startActivity(intent);
            }
        });

//        //第九种
//        setContentView(R.layout.main_menu);
//        button15 = (Button) findViewById(R.id.button15);
//        button16 = (Button) findViewById(R.id.button16);
//        button15.setVisibility(View.INVISIBLE);
//        button16.setVisibility(View.INVISIBLE);

//        //第八种
//        setContentView(R.layout.main_date);
//
//        Calendar can = Calendar.getInstance();
//        dYear = can.get(Calendar.YEAR);
//        dMonth = can.get(Calendar.MONTH);
//        dDay = can.get(Calendar.DAY_OF_MONTH);
//        dHour = can.get(Calendar.HOUR_OF_DAY);
//        dMin = can.get(Calendar.MINUTE);
//        myTextView14 = (TextView) findViewById(R.id.myTextView14);
//        myDatePicker = (DatePicker) findViewById(R.id.myDatePicker);
//        myDatePicker.init(dYear, dMonth, dDay, new DatePicker.OnDateChangedListener(){
//
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                dYear = year;
//                dMonth = monthOfYear;
//                dDay = dayOfMonth;
//                updateDateDisplay();
//            }
//        });
//
//        myTimePicker = (TimePicker) findViewById(R.id.myTimePicker);
//        myTimePicker.setIs24HourView(true);
//        myTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                dHour = hourOfDay;
//                dMin = minute;
//                updateDateDisplay();
//            }
//        });
//
//        this.updateDateDisplay();

        //第七种
//        setContentView(R.layout.main_progressbar);
//        myButton13 = (Button) findViewById(R.id.myButton13);
//        myProgresBar = (ProgressBar) findViewById(R.id.myProgresBar);
//        myTextView13 = (TextView) findViewById(R.id.myTextView13);
//        myProgresBar.setIndeterminate(false);
//        myButton13.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                        myTextView13.setText("start");
//                        myProgresBar.setVisibility(View.VISIBLE);
//                        myProgresBar.setMax(100);
//                        myProgresBar.setProgress(0);
//
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                        for(int i=0;i<10;i++){
//                            intCounter = (i+1) * 20;
//                            try {
//                                Thread.sleep(1000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            Message msg = new Message();
//                            if(i == 4){
//                                //Stop
//                                msg.what = 1000;
//                            }else{
//                                //Notify
//                                msg.what = 2000;
//                            }
//                            MainActivity.this.myMessageProgress.sendMessage(msg);
//                        }
//                    }
//                }).start();
//
//                myMessageProgress = new Handler(){
//                    @Override
//                    public void handleMessage(Message msg) {
//                        switch (msg.what){
//                            case 1000:
//                                myTextView13.setText("already done");
//                                myProgresBar.setVisibility(View.GONE);
//                                Thread.currentThread().interrupt();
//                                break;
//
//                            case 2000:
//                                if(Thread.currentThread().isInterrupted()){
//                                    myProgresBar.setProgress(intCounter);
//                                    myTextView13.setText("no done");
//                                }
//                                break;
//                        }
//                        super.handleMessage(msg);
//                    }
//                };
//            }
//        });

        //第六种
//        setContentView(R.layout.main_clock);
//        AnalogClock myclock = (AnalogClock)findViewById(R.id.myclock);
//        myTextView12 = (TextView) findViewById(R.id.myTextView12);
//
//        mHandler = new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                System.out.println("9999999999999999999");
//                switch (msg.what){
//                    case 1234:
//                        myTextView12.setText(mHour + ":" + mMin);
//                        break;
//                }
//                super.handleMessage(msg);
//            }
//        };
//
//        mClockThread = new LooperThread();
//        mClockThread.start();

        //第五种
//        setContentView(R.layout.main_search);
//        keyword_et = (EditText)findViewById(R.id.keyword_et);
//        result_tv = (TextView)findViewById(R.id.result_tv);
//        Button btn_search = (Button)findViewById(R.id.btn_search);
//
//        btn_search.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                if(keyword_et.getText().toString().equals("")){
//                    result_tv.setText("关键字不能为空。");
//                }else{
//                    result_tv.setText(searchFile(keyword_et.getText().toString()));
//                }
//            }
//        });

        //第四种
//        setContentView(R.layout.main_image);
//        imageView1 = (ImageView)findViewById(R.id.imageView1);
//        imageView2 = (ImageView)findViewById(R.id.imageView2);
//
//        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.a));
//        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.b));

        //第三种
//        setContentView(R.layout.activity_main);
//        t = (TextView) findViewById(R.id.textView2);
//        t.setText("hemin123");
//        t.setBackgroundColor(Color.GREEN);

//        Button b = (Button) findViewById(R.id.button);
//        ButtonListener listener = new ButtonListener();
//        b.setOnClickListener(listener);
//        et = (EditText) findViewById(R.id.tx_username);
//        Button btn_commit = (Button) findViewById(R.id.btn_commit);
//        btn_commit.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                tv.setText(et.getText());
//            }
//        });
//
//        tv = (TextView) findViewById(R.id.textView1);
//        tv.setText("123456789");
//        tv.setTypeface(null, Typeface.BOLD_ITALIC);
//
//
//        cbPlain = (CheckBox)findViewById(R.id.cb_plain);
//        cbSerif = (CheckBox)findViewById(R.id.cb_serif);
//        showCbValue = (TextView) findViewById(R.id.tvShowCbValue);
//        Button btn_getCbValue = (Button) findViewById(R.id.btn_getCbValue);
//        btn_getCbValue.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                String r = "";
//                if(cbPlain.isChecked()){
//                    r += "," + cbPlain.getText();
//                }
//                if(cbSerif.isChecked()){
//                    r += "," + cbSerif.getText();
//                }
//                showCbValue.setText(r);
//            }
//        });
//
//        rgMenu = (RadioGroup) findViewById(R.id.rg_Menu);
//        Button btn_get = (Button) findViewById(R.id.btn_get);
//        btn_get.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                int id = rgMenu.getCheckedRadioButtonId();
//                Toast.makeText(MainActivity.this, id + "", Toast.LENGTH_SHORT).show();
//            }
//        });
//        Button btn_clear = (Button) findViewById(R.id.btn_clear);
//        btn_clear.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                rgMenu.clearCheck();
//            }
//        });
//
//        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
//        List list = new ArrayList();
//        list.add("AA");
//        list.add("BB");
//        list.add("CC");
//        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);
//        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);

        //第二种
//        setContentView(R.layout.main_radio);
//        textView11 = (TextView) findViewById(R.id.textView1);
//        RadioGroup myRadioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
//        radio_man = (RadioButton) findViewById(R.id.radio_man);
//        radio_female = (RadioButton) findViewById(R.id.radio_female);
//
//        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == radio_man.getId()){
//                    textView11.setText(radio_man.getText());
//                }
//                if(checkedId == radio_female.getId()){
//                    textView11.setText(radio_female.getText());
//                }
//            }
//        });

        //第三种
//        setContentView(R.layout.main_checkedbox);
//        tv_input3 = (TextView) findViewById(R.id.tv_input3);
//        cb_A2 = (CheckBox) findViewById(R.id.cb_A2);
//        cb_B2 = (CheckBox) findViewById(R.id.cb_B2);
//        cb_C2 = (CheckBox) findViewById(R.id.cb_C2);
//
//        cb_A2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(cb_A2.isChecked() == true && cb_B2.isChecked() == true && cb_C2.isChecked() == true){
//                    tv_input3.setText("cb_A2=" + cb_A2.getText() + ", cb_B2=" + cb_B2.getText() + ", cb_C2=" + cb_C2.getText());
//                }
//            }
//        });
    }

//    class ButtonListener implements OnClickListener {
//        @Override
//        public void onClick(View v) {
//            count++;
//            //t.setText(count + "");
//            Toast.makeText(MainActivity.this, "count=" + count, Toast.LENGTH_SHORT).show();
//        }
//    }

//    private String searchFile(String keyword){
//        String result = "";
//        File[] list = new File("D:\\test\\learngit\\").listFiles();
//        if(list == null){
//            return "找不到文件。";
//        }else{
//            for(File f : list){
//                if(f.getName().indexOf(keyword) >=0 ){
//                    return f.getAbsolutePath();
//                }
//            }
//        }
//        return "";
//    }
//
//    private int mHour;
//    private int mMin;
//    private Handler mHandler;
//    private Thread mClockThread;
//
//    class LooperThread extends Thread{
//        @Override
//        public void run() {
//            do {
//                long time = System.currentTimeMillis();
//                Calendar mCan = Calendar.getInstance();
//                mCan.setTimeInMillis(time);
//                mHour = mCan.get(Calendar.HOUR);
//                mMin = mCan.get(Calendar.MINUTE);
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                Message m = new Message();
//                m.what = 1234;
//                MainActivity.this.mHandler.sendMessage(m);
//
//            }while (MainActivity.LooperThread.interrupted()==false);
//        }
//    }

    private void updateDateDisplay(){
        myTextView14.setText(new StringBuilder()
                .append(dYear).append("/")
                .append(format(dMonth+1)).append("/")
                .append(format(dDay)).append(" ")
                .append(format(dHour)).append(":")
                .append(format(dMin))
        );
    }

    private String format(int x){
        String s = ""+x;
        if(s.length()==1){
            s = "0"+s;
        }
        return s;
    }
}
