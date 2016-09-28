package com.iflytek.viewpagerdemo.initialpage;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.iflytek.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;

public class TestInitialPage extends AppCompatActivity {

    private ViewPager mViewPager;
    private View mViewButton;

    private final List<View> viewList = new ArrayList<>();
    private final int[] images = new int[]{
            R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3,
    };
    private volatile boolean isClose = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_initial_page);

        //隐藏固定栏
        getSupportActionBar().hide();
        // 打开沉浸式状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewButton = (View) findViewById(R.id.viewButton);

        View v1 = getLayoutInflater().inflate(R.layout.view_guide_item, null);
        ImageView im1 = (ImageView) v1.findViewById(R.id.guideImage);
        im1.setImageResource(images[0]);
        viewList.add(v1);

        View v2 = getLayoutInflater().inflate(R.layout.view_guide_item, null);
        ImageView im2 = (ImageView) v2.findViewById(R.id.guideImage);
        im2.setImageResource(images[1]);
        viewList.add(v2);

        View v3 = getLayoutInflater().inflate(R.layout.view_guide_item, null);
        ImageView im3 = (ImageView) v3.findViewById(R.id.guideImage);
        im3.setImageResource(images[2]);
        viewList.add(v3);

        mViewPager.setAdapter(new ViewPageAdapter());
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    mViewButton.setVisibility(View.VISIBLE);
                } else {
                    mViewButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("mViewButton", "可以跳转了.");
                Toast.makeText(TestInitialPage.this, "可以跳转了.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    class ViewPageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = viewList.get(position);
            container.addView(view, position);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
    }
}
