package com.minbo.testdemo.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minbo.testdemo.R;


public class RightFragment extends Fragment {

    private TextView textRight;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, null);
        TextView textRight = (TextView) view.findViewById(R.id.textRight);
        textRight.setText(getArguments().getString("city"));
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
