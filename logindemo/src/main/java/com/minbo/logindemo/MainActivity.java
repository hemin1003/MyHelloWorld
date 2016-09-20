package com.minbo.logindemo;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button cancelBtn, commitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        
        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        commitBtn = (Button) findViewById(R.id.commitBtn);
        
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                password.setText("");
            }
        });
        
        commitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().trim().equals("hemin") &&
                        password.getText().toString().trim().equals("123456")){
                    Toast.makeText(MainActivity.this, "登录成功.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "用户名或密码错误.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        FloatingActionButton myfloat = (FloatingActionButton) findViewById(R.id.myfloat);
        myfloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点我干嘛.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
