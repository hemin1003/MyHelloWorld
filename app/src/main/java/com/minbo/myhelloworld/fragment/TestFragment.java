package com.minbo.myhelloworld.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

public class TestFragment extends AppCompatActivity {

    private Button btnAddFragment;
    private LinearLayout bottomLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);

        btnAddFragment = (Button) findViewById(R.id.btnAddFragment);
        bottomLayout = (LinearLayout) findViewById(R.id.bottomLayout);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        btnAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirstFragment fragment = new FirstFragment();
                fragmentTransaction.add(R.id.bottomLayout, fragment);
                fragmentTransaction.commit();

                Button button = (Button) fragment.getActivity().findViewById(R.id.button);

                Toast.makeText(TestFragment.this, button.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
