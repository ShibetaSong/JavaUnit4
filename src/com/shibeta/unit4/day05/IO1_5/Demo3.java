package com.shibeta.unit4.day05.IO1_5;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * 文件过滤器
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        File e = new File("D:\\");
        listFiles(e);


    }

    public static void listFiles(File file) {
        // 1. 创建一个过滤器并描述规则
        FileFilter filter = new AVIFileFilter();
        // 2. 通过文件获取子文件夹
        File[] files = file.listFiles(filter);
        if (files != null && files.length > 0)
        for (File f: files) {
            if (f.isDirectory()) {
                listFiles(f);
            } else {
                System.out.println("发现一个目标文件" + f.getAbsolutePath());
            }
        }
    }

    static class AVIFileFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".txt") || pathname.isDirectory();
        }
    }
}
