package com.iflytek.viewpagerdemo.TabLayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iflytek.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;

public class TestTabLayout extends AppCompatActivity {

    private TabLayout myTabLayout;
    private ViewPager viewpager;

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> tabTitle = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tab_layout);

        myTabLayout = (TabLayout) findViewById(R.id.myTabLayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        this.initData();

        for (int i = 0; i < tabTitle.size(); i++) {

        }

    }

    private void initData() {
        tabTitle.add("最新");
        tabTitle.add("移动开发");
        tabTitle.add("前端");
        tabTitle.add("系统&安全");
        tabTitle.add("数据库");
        tabTitle.add("业界");
        tabTitle.add("语言");
        tabTitle.add("云计算");
        tabTitle.add("游戏&图像");
        tabTitle.add("大数据");
        tabTitle.add("软件工程");
        tabTitle.add("程序人生");
    }
}
