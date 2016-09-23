package com.minbo.testdemo.fragmentmenu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.minbo.testdemo.R;

public class TestMenu extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_menu);
        manager = getFragmentManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        transaction = manager.beginTransaction();
        switch (item.getItemId()){
            case R.id.sys:
                Toast.makeText(TestMenu.this, "系统管理", Toast.LENGTH_SHORT).show();
                SysFragment sys = new SysFragment();
                transaction.replace(R.id.activity_test_menu, sys, "sys");
                transaction.addToBackStack("sys");
                break;

            case R.id.user:
                Toast.makeText(TestMenu.this, "用户管理", Toast.LENGTH_SHORT).show();
                UserFragment user = new UserFragment();
                transaction.replace(R.id.activity_test_menu, user, "user");
                transaction.addToBackStack("user");
                break;

            case R.id.product:
                Toast.makeText(TestMenu.this, "产品管理", Toast.LENGTH_SHORT).show();
                ProductFragment product = new ProductFragment();
                transaction.replace(R.id.activity_test_menu, product, "product");
                //加入回退栈
                transaction.addToBackStack("product");
                break;
        }
        transaction.commit();
        return super.onOptionsItemSelected(item);
    }
}
