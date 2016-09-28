package com.iflytek.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class TestViewPager extends AppCompatActivity {

    private List<Fragment> mFragmentList = new ArrayList<>();

    private ViewPager myViewpager;

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_pager);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        mFragmentList.add(fragment1);
        mFragmentList.add(fragment2);
        mFragmentList.add(fragment3);

        //MyAdapter adapter = new MyAdapter(this.getSupportFragmentManager(), mFragmentList);
        MyStateAdapter adapter = new MyStateAdapter(this.getSupportFragmentManager(), mFragmentList);

        myViewpager = (ViewPager) findViewById(R.id.myViewPager);
        myViewpager.setAdapter(adapter);

    }

    class MyAdapter extends FragmentPagerAdapter{

        private List<Fragment> mFragmentList;

        public MyAdapter(FragmentManager fm, List<Fragment> mFragmentList) {
            super(fm);
            this.mFragmentList = mFragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }


    class MyStateAdapter extends FragmentStatePagerAdapter{

        private List<Fragment> mFragmentList;

        public MyStateAdapter(FragmentManager fm, List<Fragment> mFragmentList) {
            super(fm);
            this.mFragmentList = mFragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
