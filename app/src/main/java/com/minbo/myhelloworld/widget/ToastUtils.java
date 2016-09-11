package com.minbo.myhelloworld.widget;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Minbo on 9/11/16.
 */
public class ToastUtils {
    private static Toast toast;

    public static void showToast(Context context,
                                 String content) {
        if (toast == null) {
            toast = Toast.makeText(context,
                    content,
                    Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
}
