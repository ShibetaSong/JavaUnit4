package com.shibeta.unit4.day05.IO1_5;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo2_test_filesFilter {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            String sPath = "D://";
            System.out.print("输入要筛选的后缀(不筛选请输入$N)：");
            ArrayList<String> files = getAllFiles(sPath, input.nextLine());
            System.out.print("是否结束(y):");

        } while (!input.nextLine().equals("y"));



    }
    public static ArrayList<String> getAllFiles(String path) {
        return getAllFiles(path, "$N");
    }

    public static ArrayList<String> getAllFiles(String path, String filter) {
        File file = new File(path);
        ArrayList<String> allFiles = new ArrayList<>();


        if (file.isFile()) {
            ArrayList<String> thisFile = new ArrayList<>();
            thisFile.add(file.getAbsolutePath());
            return thisFile;
        } else {
            if (file.length() == 0) {
                return new ArrayList<>();
            }
        }



        File[] files = file.listFiles();
        if (files == null) {
            return new ArrayList<>();
        }
        for (File f : files) {
            if (f.isFile()) {
                if (filter.equals("$N")) {
                    System.out.println("正在检索：" + f.getAbsolutePath());
                } else {
                    if (f.getName().endsWith("."+filter)) {
                        System.out.println("正在检索：" + f.getAbsolutePath());
                    }
                }
                allFiles.add(f.getAbsolutePath());
            }else{
                allFiles.addAll(getAllFiles(f.getAbsolutePath(), filter));
            }
        }

        return allFiles;
    }
}
