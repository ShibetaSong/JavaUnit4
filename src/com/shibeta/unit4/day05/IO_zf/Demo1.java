package com.shibeta.unit4.day05.IO_zf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Demo1 {
    /**
     * 字符输出
     * FileWriter(fileName) 根据路径打开
     *
     * @param args a
     * @throws IOException a
     */
    public static void main(String[] args) throws IOException {
        // Writer
        FileWriter fw = new FileWriter("d://haha/1.txt");
        fw.write("锄禾日当午，汗滴禾下土");
//        FileWriter fw2 = (FileWriter) fw.append("嗯"); // 与write一致，但会返回fw
//        System.out.println(fw == fw2);
        fw.append("haha").append("hahaha2");

        // 刷新管道
        fw.flush();
        fw.close();

    }

}
