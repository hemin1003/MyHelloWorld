package com.minbo.myhelloworld.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

public class TestFragment extends AppCompatActivity implements View.OnClickListener{


    private Button btnProduct;
    private Button btnSit;
    private Button btnUat;
    private Button btnLeft;
    private EditText myEditText2;
    private Fragment left, right;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);

        btnProduct = (Button) findViewById(R.id.btnProduct);
        btnSit = (Button) findViewById(R.id.btnSit);
        btnUat = (Button) findViewById(R.id.btnUat);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        myEditText2 = (EditText) findViewById(R.id.myEditText2);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        left = new LeftFragment();
        right = new RightFragment();
        //Activity传递值到Fragment
        Bundle leftBundle = new Bundle();
        leftBundle.putString("id", "100");
        left.setArguments(leftBundle);
        Bundle rightBundle = new Bundle();
        rightBundle.putString("id", "200");
        right.setArguments(rightBundle);
        fragmentTransaction.replace(R.id.right, right, "right");
        fragmentTransaction.replace(R.id.left, left, "left");
        fragmentTransaction.commit();

        //设置按钮的监听器
        btnProduct.setOnClickListener(this);
        btnSit.setOnClickListener(this);
        btnUat.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction();

        switch(v.getId()){

            case R.id.btnProduct:
                Toast.makeText(TestFragment.this, "Click btnProduct", Toast.LENGTH_SHORT).show();
                FirstFragment1 fragment1 = new FirstFragment1();
                fragmentTransaction.replace(R.id.bottomLayout, fragment1, "fragment1");
                //添加到回退栈中
                //TODO 问题：多次加入回退栈后，也同时需要多次才能退出回退找，能不能设置无论多次，只有一次回退动作？
                fragmentTransaction.addToBackStack("fragment1");
                break;

            case R.id.btnSit:
                Toast.makeText(TestFragment.this, "Click btnSit", Toast.LENGTH_SHORT).show();
                FirstFragment2 fragment2 = new FirstFragment2();
                fragmentTransaction.replace(R.id.bottomLayout, fragment2, "fragment2");
                fragmentTransaction.addToBackStack("fragment2");
                break;

            case R.id.btnUat:
                Toast.makeText(TestFragment.this, "Click btnUat", Toast.LENGTH_SHORT).show();
                FirstFragment3 fragment3 = new FirstFragment3();
                fragmentTransaction.replace(R.id.bottomLayout, fragment3, "fragment3");
                fragmentTransaction.addToBackStack("fragment3");
                break;

            case R.id.btnLeft:
                //使用接口回调的方式获取left fragment里面的值
                //注意：使用Manager寻找已初始化的Fragment，而不是重新实例化一个
                LeftFragment left = (LeftFragment) fragmentManager.findFragmentByTag("left");
                left.getEditText(new LeftFragment.CallBack() {
                    @Override
                    public void result(String result) {
                        Toast.makeText(TestFragment.this, "--->" + result, Toast.LENGTH_SHORT).show();
                    }
                });
                break;

        }
        //每次Fragment内容有变化时都需要调用commit才能生效
        fragmentTransaction.commit();
    }
}
