package com.shibeta.unit4.day05.IO1_5;

import java.io.File;

public class Demo2 {
    public static void main(String[] args) {
        File d = new File("D:\\");
        File[] files = d.listFiles();
        listFiles(files);
    }

    public static void listFiles(File[] files) {
        if (files != null && files.length > 0) {
            for (File file: files) {
                if (file.isFile()) {
                    // 文件
                    if (file.getName().endsWith(".a")) {
                        // 找到了一个avi文件
                        System.out.println("找到了一个a文件" + file.getAbsolutePath());
                        file.delete();
                        System.out.println(file.getAbsolutePath() + "文件已删除");
                    }
                } else {
                    // 文件夹
                    File[] files2 = file.listFiles();
                    listFiles(files2);
                }

            }
        }
    }
}
