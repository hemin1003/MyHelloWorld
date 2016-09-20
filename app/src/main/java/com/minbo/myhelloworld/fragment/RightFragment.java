package com.minbo.myhelloworld.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.minbo.myhelloworld.R;


public class RightFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.right_fragment, null);
        //获取从Activity传递过来的值
        TextView myTextView1 = (TextView) view.findViewById(R.id.myTextView2);
        myTextView1.setText(getArguments().getString("id"));
        //获取从Fragment传递过来的值
        EditText myEditText3 = (EditText) view.findViewById(R.id.myEditText3);
        myEditText3.setText(getArguments().getString("id"));
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
