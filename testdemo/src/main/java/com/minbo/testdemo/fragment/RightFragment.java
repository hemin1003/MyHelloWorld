package com.minbo.testdemo.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minbo.testdemo.R;


public class RightFragment extends Fragment {

    public static RightFragment newInstance(String city) {
        RightFragment fragment = new RightFragment();
        Bundle args = new Bundle();
        args.putString("city", city);
        Log.i("RightFragment city=", city);
        fragment.setArguments(args);
        return fragment;
    }

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
