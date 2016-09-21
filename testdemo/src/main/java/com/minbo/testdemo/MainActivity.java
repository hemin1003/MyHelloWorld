package com.minbo.testdemo;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import com.minbo.testdemo.fragment.TestListFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast = (Button) findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Snackbar comes out", Snackbar.LENGTH_LONG)
                        .setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(
                                        MainActivity.this,
                                        "Toast comes out",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        final TextInputLayout myInput = (TextInputLayout) findViewById(R.id.myInput);
        EditText edit = myInput.getEditText();
        myInput.setHint("password");
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
                if(s.length()>4){
                    myInput.setError("Error");
                    myInput.setErrorEnabled(true);
                }else{
                    myInput.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        TabLayout myTabLayout = (TabLayout) findViewById(R.id.myTabLayout);

        myTabLayout.addTab(myTabLayout.newTab().setText("Tab111"));
        myTabLayout.addTab(myTabLayout.newTab().setText("Tab222"));
        myTabLayout.addTab(myTabLayout.newTab().setText("Tab333"));

        Button btnListFragment = (Button) findViewById(R.id.btnListFragment);
        btnListFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TestListFragment.class);
                startActivity(intent);
            }
        });
    }
}
