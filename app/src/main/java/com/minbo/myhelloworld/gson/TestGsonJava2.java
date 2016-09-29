package com.minbo.myhelloworld.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.minbo.myhelloworld.gson.javabean.People;
import com.minbo.myhelloworld.gson.javabean.User;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/29.
 */

public class TestGsonJava2 {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // @SerializedName 注解的使用
        //注意：就算数据和实体类字段不一致，解析时也不会报错，只会返回一个NULL结果
        String data = "{\"name\":\"小明\",\"home_address\":\"中国xxxxxxxxxx\",\"age\":16,\"sex\":true}  \n";
        User user = gson.fromJson(data, User.class);
//        System.out.println(user.toString());

        String data1 = "{\"name\":\"小花\",\"home\":\"中国xxxxxxxxxx\",\"age\":20,\"sex\":true}  \n";
        User user1 = gson.fromJson(data1, User.class);
//        System.out.println(user1.toString());

        //显示Null的值
        Gson gson2 = new GsonBuilder().serializeNulls().create();
        User user2 = new User("小明", true, 16, null);
        String strJson = gson2.toJson(user2);
//        System.out.println(strJson);

        //序列化的控制
        Gson gson3 = new GsonBuilder().disableInnerClassSerialization().setDateFormat("YYYY-MM-DD").disableHtmlEscaping().create();
        People people = new People("张三", new Date(), 20);
        String peoples = gson3.toJson(people);
//        System.out.println(peoples);

        //注解@Expose的使用
        Gson gson4 = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
//        System.out.println(gson4.toJson(people));

        //@Since(int i)和@Until(int i)的用法
        Gson gson5 = new GsonBuilder().setVersion(6).create();
        System.out.println("gson5=" + gson5.toJson(people));

    }
}
