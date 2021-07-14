package com.shibeta.unit4.day05.IO_Last;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Demo2_properties {
    public static void main(String[] args) throws IOException {
        // properties 与IO、Map都有关，双值存储
//        // .properties文件 与 Properties类
//        Properties ppt = new Properties();
//        // 键=值
//        ppt.put("name", "金苹果");
//        ppt.put("info", "讲述了苹果种植的过程");
//        FileWriter fw = new FileWriter("d://haha/book.properties");
//        ppt.store(fw, "存储的图书");
//        fw.close();

        Properties ppt = new Properties();
        ppt.load(new FileReader("d://haha/book.properties"));
        System.out.println(ppt.getProperty("name"));
        System.out.println(ppt.getProperty("info"));

    }
}
