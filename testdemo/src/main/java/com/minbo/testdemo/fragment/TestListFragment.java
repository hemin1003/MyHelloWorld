package com.minbo.testdemo.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.minbo.testdemo.R;

public class TestListFragment extends AppCompatActivity {

    private Button myBtn;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list_fragment);

        manager = getFragmentManager();
        myBtn = (Button) findViewById(R.id.myBtn);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TestListFragment.this, "Test", Toast.LENGTH_SHORT).show();
                transaction = manager.beginTransaction();
                MiddleFragment middele = new MiddleFragment();
                transaction.replace(R.id.middleLayout, middele, "middle");
                transaction.addToBackStack("middle");
                transaction.commit();
            }
        });
    }
}
