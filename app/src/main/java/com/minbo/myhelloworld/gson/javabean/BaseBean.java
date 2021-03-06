package com.minbo.myhelloworld.gson.javabean;

import android.os.Message;

/**
 * Created by Administrator on 2016/9/29.
 */

public class BaseBean<T> {
    private String code;
    private String  message;
    private T data;

    public BaseBean(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "code='" + code + '\'' +
                ", message=" + message +
                ", data=" + data +
                '}';
    }
}
