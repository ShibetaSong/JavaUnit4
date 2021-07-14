package com.shibeta.unit4.day05.IO_zf;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Demo3_zh {
    // 转换流
    // 字节流 '装饰'为 字符流 : 使用了装饰者设计模式
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("d://haha/1.txt");

        // 将字节输入流，装饰为字符输入流
        // 参数1. 要转换的字节流
        // 参数2. 指定编码名称
//        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
//        while (true) {
//            int c = isr.read();
//            if (c == -1) {
//                break;
//            }
//            System.out.println((char) c);
//        }
        FileOutputStream fos = new FileOutputStream("d://haha/1.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("床前明月光");
        osw.flush();
        osw.close();
    }

}
