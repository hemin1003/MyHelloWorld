package com.minbo.myhelloworld.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

public class TestFragment extends AppCompatActivity implements View.OnClickListener{


    private Button btnProduct;
    private Button btnSit;
    private Button btnUat;


    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);

        btnProduct = (Button) findViewById(R.id.btnProduct);
        btnSit = (Button) findViewById(R.id.btnSit);
        btnUat = (Button) findViewById(R.id.btnUat);

        fragmentManager = getFragmentManager();

        btnProduct.setOnClickListener(this);
        btnSit.setOnClickListener(this);
        btnUat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(TestFragment.this, "Click", Toast.LENGTH_SHORT).show();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch(v.getId()){

            case R.id.btnProduct:
                Toast.makeText(TestFragment.this, "Click btnProduct", Toast.LENGTH_SHORT).show();
                FirstFragment1 fragment1 = new FirstFragment1();
                fragmentTransaction.replace(R.id.bottomLayout, fragment1, "fragment1");
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
        }
        fragmentTransaction.commit();
    }
}
