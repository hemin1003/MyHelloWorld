package com.iflytek.viewpagerdemo.initialpage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/9/7.
 */
public class SharedHelper {

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Context context;

    public SharedHelper(Context c, String name){
        context = c;
        sp = context.getSharedPreferences(name, 0);
        editor = sp.edit();
    }

    public void putValue(String key, String value){
        editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getValue(String key){
        return sp.getString(key, null);
    }
}
