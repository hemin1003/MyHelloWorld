package com.minbo.myhelloworld.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

import java.util.ArrayList;
import java.util.List;

public class TestListview extends AppCompatActivity {

    private ListView myListview;
    private List<String> listdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_listview);

        myListview = (ListView) findViewById(R.id.myListView);
        this.initDatas();
        myListview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listdata));
        myListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TestListview.this, "" + listdata.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDatas() {
        listdata = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            listdata.add("北京" + i);
        }
    }
}
