package com.shibeta.unit4.day05.IO1_5;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Demo3_upgrade {
    public static void main(String[] args) throws IOException {
        File e = new File("D:\\");
        listFiles(e);


    }

    public static void listFiles(File file) {
        // 1. 创建一个过滤器并描述规则  匿名内部类
//        FileFilter filter = new Demo3.AVIFileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().endsWith(".txt") || pathname.isDirectory();
//            }
//        };
        // 2. 通过文件获取子文件夹
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt") || pathname.isDirectory();
            }
        });
        if (files != null && files.length > 0)
            for (File f: files) {
                if (f.isDirectory()) {
                    listFiles(f);
                } else {
                    System.out.println("发现一个目标文件" + f.getAbsolutePath());
                }
            }
    }
}
