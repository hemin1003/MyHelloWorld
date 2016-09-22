package com.minbo.myhelloworld.intent;

import java.io.Serializable;

public class PersonSer implements Serializable{

    //serialVersionUID的作用是在修改实体类后，可以正常的序列化和反序列化
    private static final long serialVersionUID = -7620435178023928252L;

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
