package com.minbo.testdemo.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.minbo.testdemo.R;


public class MiddleFragment extends ListFragment {

    String[] cities = {
            "Shenzhen",
            "Beijing",
            "Shanghai",
            "Guangzhou",
            "Wuhan",
            "Tianjing",
            "Changsha",
            "Xi'an",
            "Chongqing",
            "Guilin",
            "Hunan",
            "Hengyang",
            "Changsha",
            "Nanning",
            "Guiyang",
            "Yunnan",
            "Foshan",
            "Zhongsan",
            "Beihai",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cities));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_middle, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), "" + cities[position], Toast.LENGTH_SHORT).show();

        FragmentManager manager = getActivity().getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        RightFragment right = RightFragment.newInstance(cities[position]);
        transaction.replace(R.id.rightLayout, right, "right");
        transaction.addToBackStack("right");
        transaction.commit();
    }
}
