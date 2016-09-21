package com.minbo.testdemo.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.minbo.testdemo.R;
import com.minbo.testdemo.fragmenttest.ItemFragment;
import com.minbo.testdemo.fragmenttest.dummy.DummyContent;

public class TestListFragment extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener{

    private Button myBtn,btnListFragment;
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

        btnListFragment = (Button) findViewById(R.id.btnListFragment);
        btnListFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = manager.beginTransaction();
                ItemFragment item = new ItemFragment();
                transaction.replace(R.id.middleLayout, item, "item");
                transaction.addToBackStack("item");
                transaction.commit();
            }
        });
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(TestListFragment.this, "" + item.toString(), Toast.LENGTH_SHORT).show();
    }
}
