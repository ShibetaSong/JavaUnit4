package com.shibeta.unit4.day05.ioFile.practice;

import java.io.File;

public class fileProcess {
    public static void main(String[] args) {
        File file = new File("./src/com/shibeta/unit4/day05/ioFile");
        File[] files = file.listFiles();
        listFiles(files);
    }

    public static void listFiles(File[] files) {
        if (files != null && files.length > 0) {
            for (File file: files) {
                if (file.isFile()) {
                    // 文件
                    if (file.length() < 100) {
//                        if (file.getName().endsWith(".avi")) {
//                            // 找到了一个avi文件
//                            System.out.println("avi文件" + file.getAbsolutePath());
//                        } else {
//                            // 其他文件
//                            System.out.println("不是avi文件：" + file.getAbsolutePath());
                        file.delete();
                        System.out.println(file.getAbsolutePath()+"已删除");
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
