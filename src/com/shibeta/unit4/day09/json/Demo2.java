package com.shibeta.unit4.day09.json;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
//        // 1. 创建Gson对象
//        Gson g = new Gson();
//        // 2. 转换
//        Book book = g.fromJson("{\"id\":\"100\",\"name\":\"金苹果\",\"info\":\"种植苹果真辛苦\"}", Book.class);
        HashMap<?, ?> str = new Gson().fromJson("{\"id\":\"100\",\"name\":\"金苹果\",\"info\":\"种植苹果真辛苦\"}", HashMap.class);
        System.out.println(str);
//        System.out.println(book.getId());
//        HashMap<?, ?> data = new Gson().fromJson("{\"id\":\"100\",\"name\":\"金苹果\",\"info\":\"种植苹果真辛苦\", \"page\":[\"哈哈哈\"]}", HashMap.class);
//        List<?> page = (List<?>) data.get("page");
//        System.out.println(page.get(0));


        // 获取到的是ArrayList，不是数组
//        System.out.println(data.get("page"));

    }

}
