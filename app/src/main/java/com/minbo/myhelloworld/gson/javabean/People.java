package com.minbo.myhelloworld.gson.javabean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/29.
 */

public class People {
    @Expose(deserialize = false,serialize = true)
    private String name;
    @Since(2)
    private Date date;
    @Until(5)
    private int age;

    public People(String name, Date date, int age) {
        this.name = name;
        this.date = date;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", age=" + age +
                '}';
    }
}