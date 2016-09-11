package com.minbo.myhelloworld.widget;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.minbo.myhelloworld.R;

public class TestDailog extends AppCompatActivity {

    private Button btn_Snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dailog);

        /**
        *
         * http://www.open-open.com/lib/view/open1469613952067.html
        Dialog：当提示信息是至关重要的，并且必须要由用户做出决定才能继续的时候，使用Dialog。
        Toast：当提示信息只是告知用户某个事情发生了，用户不需要对这个事情做出响应的时候，使用Toast。
        Snackbar：以上两者之外的任何其他场景，Snackbar可能会是你最好的选择。

        * */

        Button btn_Toast = (Button) findViewById(R.id.btn_Toast);
        Button btn_Dailog = (Button) findViewById(R.id.btn_Dailog);
        btn_Snackbar = (Button) findViewById(R.id.btn_Snackbar);

        btn_Toast.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(TestDailog.this, "things happened", Toast.LENGTH_SHORT).show();
                ToastUtils.showToast(TestDailog.this, "things happened");
            }
        });

        btn_Dailog.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestDailog.this);
                builder.setTitle("Title")
                        .setMessage("Dialog content.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Log.i("Dialog", "You Ok me!");
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Log.i("Dialog", "You Cancelled me!");
                            }
                        })
                        .show();
            }
        });

        btn_Snackbar.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = btn_Snackbar.getText().toString();
                Snackbar.make(v, "data deleted",Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                Log.i("Snack", "You clicked me!");
                            }
                        })
                        .show();
            }
        });

    }
}
