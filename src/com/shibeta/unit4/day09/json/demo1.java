package com.shibeta.unit4.day09.json;

import com.google.gson.Gson;

public class demo1 {
/*
JavaScript Object Notation JS对象简谱, 轻量级的数据交换格式

建议使用Gson，fastjson可能有重要漏洞

键值对 应加引号，否则Java解析可能出错
对象格式: {}
数组格式: []

 */
public static void main(String[] args) {
//    // 1. 创建Gson对象
//    Gson g = new Gson();
//    // 2. 转换
//    Book b = new Book("100", "金苹果", "种植苹果真辛苦");
//    String s = g.toJson(b);
//    System.out.println(s);
    System.out.println(new Gson().toJson(new Book("100", "金苹果", "种植苹果真辛苦"))
);
}

}
