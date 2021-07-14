package com.shibeta.unit4.day05.IO1_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Demo4 {
    /**
     *  IO 流
     *      数据传输的操作 看作数据的流动。 按照流动的方向作为输入Input和输出Output
     *      Java中的IO操作主要指的是 java.io包下的一些常用类的使用。
     *      通过这些类对数据进行读取（输入Input）和写出（输出Output）
     *
     *  IO流分类：
     *      按照方向：输入流和输出流
     *      按照数据类型：字节流和字符流
     *
     *      字节流：
     *          -   输入： InputStream
     *          -   输出： OutputStream
     *
     *      字符流：
     *          -   输入： Reader
     *          -   输出： Writer
     *
     *  一切皆字节：
     *      计算机中的任何数据(文本、图片、视频、音乐等)都是以二进制的形式存储的
     *      在数据传输时，也都是以二进制的形式存储的。
     *      后续学习的任何流，在传输时底层都是二进制。
     *  OutputStream 抽象类
     *      close()
     *      flush() 刷新（写出缓冲）
     *      nullOutputStream()  返回一个新的OutputStream，丢弃所有字节
     *      write(byte[] b) 将b.length字节从指定的字节数组写入此输出流
     *      write(byte[] b, int off, int len)
     *      write(int b) 将一个字节（int的八个低位）写入输出流
     *          int 4个字节 = 32bit， 1个字节 = 8bit
     *
     *  OutputStream - FileOutputStream
     *
     *  构造方法
     *  FileOutputStream(File file)
     *  FileOutputStream(File file, boolean append)
     *  FileOutputStream(String name)
     *  FileOutputStream(String name, boolean append)
     *
     *  InputStream
     *      close()
     *      read()  读取下一个数据字节   返回int，0-255. 返回-1表示到达末尾，没有可用字节。
     *      read(byte[] b)  读取一些字节数并存储到数组b
     *      read(byte[] b, int off, int len)
     *
     *  InputStream - FileInputStream
     *
     *  构造方法
     *      FileInputStream(File file)
     *      FileInputStream(String name)
     *
     *
     */
    public static void main(String[] args) throws IOException {
//        // FileOutputStream
//        FileOutputStream fos = new FileOutputStream("d://haha/1.txt");
//
//        // ASCII 码 ABCDE
////        byte[] bytes = {65, 66, 67, 68, 69};
////        fos.write(bytes);
////        fos.close();
////        System.out.println("已经写出");
//        byte[] bytes = "ABCDEFG".getBytes(StandardCharsets.UTF_8);
//        // 从1下标，写2个内容
//        fos.write(bytes, 1, 2);
//        System.out.println("已经写出");

        // InputStream
        FileInputStream fis = new FileInputStream("d://haha/a.txt");
//        while (true) {
//            byte b = (byte) fis.read();
//            if (b == -1) {
//                break;
//            }
//            System.out.println((char) b);
//        }
        byte[] bytes = new byte[10];
//
        int len = fis.read(bytes);
        System.out.println(new String(bytes, 0, len));
        len = fis.read(bytes);
        System.out.println(new String(bytes, 0, len));
        len = fis.read(bytes);
        System.out.println(new String(bytes, 0, len));
        len = fis.read(bytes);
        System.out.println(len);
        fis.close();

        /*
        字节流读取文字，容易出现‘读字不全、读了一半的字’的问题
         */


    }
}
