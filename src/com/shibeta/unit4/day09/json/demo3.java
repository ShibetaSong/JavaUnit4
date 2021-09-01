package com.shibeta.unit4.day09.json;

import com.alibaba.fastjson.JSON;

public class demo3 {
/*
fastjson
 */
public static void main(String[] args) {
    Book book = new Book("1002", "唐诗三百首", "床前明月光, 地上鞋两双. 床上一个牌, 十块钱一双");
    String json = JSON.toJSONString(book);
    System.out.println(json);
}
}
