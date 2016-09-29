package com.minbo.myhelloworld.gson;

import com.google.gson.Gson;
import com.minbo.myhelloworld.gson.javabean.BaseBean;
import com.minbo.myhelloworld.gson.javabean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/29.
 */

public class TestGsonJava1 {
    public static void main(String[] args) {
        System.out.println("hello gson");

        //1.基本数据类型解析
        Gson gson = new Gson();
        int i = gson.fromJson("1", int.class);
        double b = gson.fromJson("1.11", double.class);
        double b2 = gson.fromJson("\"1.11\"", double.class);
        boolean a = gson.fromJson("true", boolean.class);
        String s = gson.fromJson("a123", String.class);
//        System.out.println("i=" + i);
//        System.out.println("b=" + b);
//        System.out.println("b2=" + b2);
//        System.out.println("a=" + (a==true));
//        System.out.println("s=" + s);

        //2.基本数据类型生成
        Gson gson2 = new Gson();
        String s1 = gson2.toJson(1);
        String s2 = gson2.toJson(false);
        String s3 = gson2.toJson("str");
//        System.out.println("s1=" + s1);
//        System.out.println("s2=" + s2);
//        System.out.println("s3=" + s3);

        //3.实体类的解析及生成
        User user = new User("小明", true, 16, "中国xxxxxxxxxx");
        String userJson = gson.toJson(user);
        System.out.println("userJson=" + userJson);
        User user1 = gson.fromJson(userJson, user.getClass());
//        System.out.println("user1=" + user1.toString());

        //4.泛型在Gson中的使用
        //a.数组
        String jsonss = "[\"aa\",\"bb\",\"cc\"]";
        String[] ss = gson.fromJson(jsonss, String[].class);
        for(String jsons : ss){
//            System.out.println(jsons);
        }

        //b.List
        List<String> list = gson.fromJson(jsonss, List.class);
//        System.out.println(list.toString());

        //c.泛型
        BaseBean<User> userBase = new BaseBean<>("123", "success", user);
        String userStr = gson.toJson(userBase);
//        System.out.println(userStr);

        BaseBean<User> userBase2 = gson.fromJson(userStr, BaseBean.class);
//        System.out.println(userBase2.toString());

        List<User> userList = new ArrayList<>();
        userList.add(new User("11",true,23,"中国11*******"));
        userList.add(new User("22",true,23,"中国22*******"));
        userList.add(new User("33",true,23,"中国33*******"));
        userList.add(new User("44",true,23,"中国44*******"));
        userList.add(new User("55",true,23,"中国55*******"));
        BaseBean<List<User>> baseBean = new BaseBean<>("456", "success", userList);
        String userbeanList = gson.toJson(baseBean);
        System.out.println("userbeanList=" + userbeanList);

        BaseBean<List<User>> myUserlist = gson.fromJson(userbeanList, BaseBean.class);
        System.out.println("myUserlist=" + myUserlist);

    }
}
