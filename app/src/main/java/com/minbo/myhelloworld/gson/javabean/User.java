package com.minbo.myhelloworld.gson.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/9/29.
 */

public class User {
    private String name;
    private boolean sex;
    private int age;
    @SerializedName(value = "homeAddress", alternate = {"home_address", "home"})
    private String homeAddress;

    public User(String name, boolean sex, int age, String homeAddress) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }
}
