package com.minbo.myhelloworld.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.minbo.myhelloworld.R;

/**
 * Android开发中有时需要在应用中或进程间传递对象，下面详细介绍Intent使用Bundle传递对象的方法。
 被传递的对象需要先实现序列化，而序列化对象有两种方式：java.io.Serializable和android.os.Parcelable

 Java中使用的是Serializable，而谷歌在Android使用了自定义的Parcelable。
 两种序列化方式的区别：

 1.在使用内存的时候，Parcelable比Serializable性能高，推荐使用Parcelable类；
 2.Serializable在序列化的时候会产生大量的临时变量，从而引起频繁的GC；
 3.Parcelable不能使用在要将数据存储在磁盘上的情况，因为Parcelable不能很好的保证数据的持续性在外界有变化的情况下，这种情况建议使用Serializable。
 */
public class TestIntent extends AppCompatActivity{

    public static final String SER_KEY = "ser_key";
    public static final String PAR_KEY = "par_key";
    public static final String SER_TYPE = "ser_type";
    public static final String PAR_TYPE = "par_type";

    private Button mSerBtn;
    private Button mParBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_intent);
        initViews();
    }

    private void initViews() {
        mSerBtn = (Button) findViewById(R.id.serializable_btn);
        mSerBtn.setOnClickListener(onClickListener);
        mParBtn = (Button) findViewById(R.id.parcelable_btn);
        mParBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(TestIntent.this, ResultActivity.class);
            Bundle bundle = new Bundle();
            switch (v.getId()) {
                case R.id.serializable_btn:
                    PersonSer personSer = new PersonSer();
                    personSer.setName("zhangsan");
                    personSer.setAge(20);
                    bundle.putSerializable(SER_KEY, personSer);
                    intent.putExtra("type", SER_TYPE);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;

                case R.id.parcelable_btn:
                    PersonPar personPar = new PersonPar();
                    personPar.setName("lisi");
                    personPar.setAge(40);
                    bundle.putParcelable(PAR_KEY, personPar);
                    intent.putExtra("type", PAR_TYPE);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
            }
        }
    };
}
