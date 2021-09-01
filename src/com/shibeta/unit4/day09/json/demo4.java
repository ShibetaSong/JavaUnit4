package com.shibeta.unit4.day09.json;

import com.alibaba.fastjson.JSON;
import java.util.List;

public class demo4 {
    public static void main(String[] args) {
//        Book book = JSON.parseObject("{\"id\":\"1002\",\"info\":\"床前明月光, 地上鞋两双. 床上一个牌, 十块钱一双\",\"name\":\"唐诗三百首\"}", Book.class);
        List<String> str = JSON.parseArray("[\"一二三\", \"四五六\", \"七八九\"]", String.class);
//        System.out.println(book.getId());
        System.out.println(str.get(1));

    }

}
