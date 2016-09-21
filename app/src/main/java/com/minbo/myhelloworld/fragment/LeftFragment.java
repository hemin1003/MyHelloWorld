package com.minbo.myhelloworld.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

import java.nio.BufferUnderflowException;


public class LeftFragment extends Fragment {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private EditText myEditText1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment, null);
        //获取从Activity传递过来的值
        TextView myTextView1 = (TextView) view.findViewById(R.id.myTextView1);
        final String id = getArguments().getString("id");
        myTextView1.setText(id);

        Button btnGetValue = (Button) view.findViewById(R.id.btnGetValue);
        btnGetValue.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
               //获取Activity中文本框中的输入值
               EditText myEditText2 = (EditText) getActivity().findViewById(R.id.myEditText2);
               Toast.makeText(getActivity(), "--->>" + myEditText2.getText().toString(), Toast.LENGTH_SHORT).show();
           }
       }
        );

        //从Left Fragment传递值到Right Fragment
        fragmentManager =  getFragmentManager();
        Button btnFragment = (Button) view.findViewById(R.id.btnFragment);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                RightFragment right = new RightFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                right.setArguments(bundle);
                transaction.replace(R.id.right, right, "right");
                transaction.commit();
            }
        });

        //获取Right Fragment里面的文本域值
        Button btnRightValue = (Button) view.findViewById(R.id.btnRightValue);
        btnRightValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RightFragment rightFragment = (RightFragment) fragmentManager.findFragmentByTag("right");
                String msg = ((TextView)rightFragment.getView().findViewById(R.id.myTextView2)).getText().toString();
                Toast.makeText(getActivity(), "--->" + msg, Toast.LENGTH_SHORT).show();
            }
        });

        myEditText1 = (EditText) view.findViewById(R.id.myEditText1);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    //利用接口回调的方式在Activity获取Fragment中的值
    public void getEditText(CallBack callback){
        String text = myEditText1.getText().toString();
        callback.result(text);
    }

    public interface CallBack{
        public void result(String result);
    }
}
