package com.shibeta.unit4.day05.字节流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FileOutput {
    /*
    OutputStream
        FileOutputStream
     */

    /**
     * OutputStream的子类
     * 构造方法：
     *  FileOutputStream(File file)
     *  FileOutputStream(File file, boolean append) append: 是否接着文件往后写
     *  FileOutputStream(String name)
     *  FileOutputStream(String name, boolean append)
     * @param args
     * FileNotFoundException: IOException的子类
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("./src/com/shibeta/unit4/day05/字节流/a.txt");
        byte[] bytes = "ABCDEF".getBytes(StandardCharsets.UTF_8);
        fos.write(bytes);
        fos.close();
    }
}
