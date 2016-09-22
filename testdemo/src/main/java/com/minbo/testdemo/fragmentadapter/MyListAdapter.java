package com.minbo.testdemo.fragmentadapter;

import android.app.ListFragment;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.minbo.testdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends ListFragment {

    private Myadapter adapter;

    public List<String> listData(){
        List list = new ArrayList();
        for (int i = 0; i < 30; i++) {
            list.add("hello" + i);
        }
        return list;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建adapter
        adapter = new Myadapter();
        //绑定数据
        adapter.bindData(listData());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //动态加载布局
        View view = inflater.inflate(R.layout.my_list_adapter_fragment, null);
        //加载完布局后才能设置适配器
        this.setListAdapter(adapter);
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(getActivity(), "" + adapter.getItem(position).toString(),
                Toast.LENGTH_SHORT).show();
    }


    ToggleButton toggleButton1;
    Switch switch1;

    @Override
    public void onPause() {
        super.onPause();
    }


    class Myadapter extends BaseAdapter{

        //数据集合
        private List<String> list;

        //绑定数据
        public void bindData(List<String> list){
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            if(convertView == null){
                view = LayoutInflater.from(getActivity()).inflate(R.layout.my_item, null);
            }else{
                view = convertView;
            }
            TextView tv = (TextView)view.findViewById(R.id.textView1);
            String str = list.get(position).toString();
            tv.setText(str);
            //默认都灰色
            final ImageView iv = (ImageView)view.findViewById(R.id.imageView1);
            iv.setImageResource(R.drawable.ic_light_close);

            toggleButton1 = (ToggleButton)view.findViewById(R.id.toggleButton1);
            switch1 = (Switch)view.findViewById(R.id.switch1);

            toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        iv.setImageResource(R.drawable.ic_light_open);

                    }else{
                        iv.setImageResource(R.drawable.ic_light_close);
                    }

                }
            });

            switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        iv.setImageResource(R.drawable.ic_light_open);

                    }else{
                        iv.setImageResource(R.drawable.ic_light_close);
                    }
                }
            });
            return view;
        }
    }
}
