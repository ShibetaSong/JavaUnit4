package com.shibeta.unit4.文档检索;


import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class FindFile {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // 程序主循环
        while (true) {
            // 文件\文件夹 根路径
            System.out.println("==========文件检索系统==========");
            System.out.print("请输入搜索的文件/文件夹路径(e以退出):");
            String filePath = input.nextLine();
            if (filePath.equals("e")) {
                break;
            }

            File dir = new File(filePath);
            if (!dir.exists()) {
                System.out.println("路径有误");
                continue;
            }

            // 文件名后缀
            System.out.print("请输入文件名后缀(无则不输入):");
            String endWith = input.nextLine();

            // 文件名包含
            System.out.print("请输入包含文件名 文件路径(无则不输入):");
            String fileNameLackPath = input.nextLine();
            ArrayList<String> nameContains = new ArrayList<>();

            if (!fileNameLackPath.equals("")) {
                File fileNameLack = new File(fileNameLackPath);
                if (!fileNameLack.isFile()) {
                    System.out.println("文件不存在!");
                    continue;
                }
                try {
                    BufferedReader br = new BufferedReader(new FileReader(fileNameLack));
                    String newTask = br.readLine();
                    do {
                        nameContains.add(newTask);
                        newTask = br.readLine();
                    } while (newTask != null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            String contain = input.nextLine();

            if (nameContains.size() <= 0) {
                nameContains.add("");
            }

            // 文件操作参数
            String desPath = "";
            System.out.print("是否保存入其他路径?(yes): ");
            boolean saveFile = false;
            if (input.nextLine().equals("yes")) {
                saveFile = true;
                System.out.print("输入保存路径: ");
                desPath = input.nextLine();
            }

            boolean removeSourceFile = false;
            System.out.print("是否删除源文件?(yes): ");
            if (input.nextLine().equals("yes")) {
                removeSourceFile = true;
            }


            for (String nameContain: nameContains) {
                // 搜寻
                ArrayList<String> files = listFiles(dir, endWith, nameContain);
                System.out.println("包含文件名为: " + nameContain);
                System.out.println("文件名结尾: " + endWith);
                System.out.println("共" + files.size() + "个文件，如下：");
                for (String each_file: files) {
                    System.out.println(each_file);
                }

//                // 文件操作参数
//                boolean saveFile = true;
//                boolean removeSourceFile = true;
//                String desPath = "";

//                // 文件操作循环
//                while (true) {
//                    System.out.print("是否保存到其他路径(yes): ");
//                    if (!input.nextLine().equals("yes")) {
//                        saveFile = false;
//                    } else {
//                        // 输入保存路径
//                        System.out.print("请输入保存目标路径: ");
//                        desPath = input.nextLine();
//                    }
//
//                    // 删除源文件
//
//                    System.out.print("是否删除源文件(yes): ");
//                    if (!input.nextLine().equals("yes")) {
//                        removeSourceFile = false;
//                    }
//
//
//
//                    System.out.println("保存到新路径 [" + saveFile + "]");
//                    System.out.println("\n删除源文件 [" + removeSourceFile + "]");
//
//                    System.out.print("\n继续执行(y)\t退出(e)\t返回上一级(b)\t返回主菜单(m): ");
//                    String s = input.nextLine();
//                    if (s.equals("e")) {
//                        System.out.println("程序结束");
//                        return;
//                    }
//                    if (s.equals("y")) {
//                        break;
//                    }
//                    if (s.equals("m")) {
//                        continue main;
//                    }
//                }

                // 操作文件
                String[] filePaths = files.toArray(new String[0]);
                System.out.println("\n==========操作文件==========");
                try {
                    saveFiles(filePaths, desPath, saveFile, removeSourceFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }
//
//    public static ArrayList<String> listFiles(File path) {
//        return listFiles(path, "", "");
//    }
//
//    public static ArrayList<String> listFiles(File path, String end) {
//        return listFiles(path, end, "");
//    }

    /**
     * 筛选文件
     * @param path 路径
     * @param end 文件结束名称
     * @param contain 文件包含名称
     * @return {ArrayList(String)} 文件绝对路径
     */
    public static ArrayList<String> listFiles(File path, String end, String contain) {
        if (path.isFile()) {
            if (!path.getName().endsWith(end) || !path.getName().contains(contain)) {
                return new ArrayList<>();
            }
            ArrayList<String> files = new ArrayList<>();
            files.add(path.getAbsolutePath());
            return files;
        }
        File[] files_list = path.listFiles();
        if (files_list == null) {
            return new ArrayList<>();
        }
        ArrayList<String> files = new ArrayList<>();
        for (File file: files_list) {
            ArrayList<String> al = listFiles(file, end, contain);
            files.addAll(al);
        }
        return files;
    }

//    public static void saveFiles(String[] filePath, boolean isSave, boolean isRemove) throws IOException{
//        if (isSave) {
//            System.out.println("保存文件却没有保存路径，你是来捣乱的吧? ");
//            return;
//        }
//        saveFiles(filePath, "", false, true);
//    }
    /**
     * 保存文件
     * @param filePath 原文件路径数组
     * @param savePath 文件保存位置
     */
    public static void saveFiles(String[] filePath, String savePath, boolean isSave, boolean isRemove) throws IOException {
        if (!isSave && !isRemove) {
            return;
        }
        for (String fileName: filePath) {
            File sourceFile = new File(fileName);
            if (!sourceFile.isFile()) {
                return;
            }
            if (isSave) {
                File save = new File(savePath);
                if (!save.isDirectory()) {
                    if (save.isFile()) {
                        System.out.println("Save Path is a File!");
                        return;
                    }
                    if (!save.mkdirs()) {
                        System.out.println("Cannot make dirs");
                        return;
                    }
                }
                save = new File(savePath + File.separator + sourceFile.getName());
                FileChannel inputFile = new FileInputStream(sourceFile).getChannel();
                FileChannel outputFile = new FileOutputStream(save).getChannel();
                outputFile.transferFrom(inputFile, 0, inputFile.size());
                inputFile.close();
                outputFile.close();
                System.out.println("====================");
                System.out.println(save.getAbsolutePath() + "文件保存成功");
            }
            if (isRemove) {
                if (sourceFile.delete()) {
                    System.out.println(sourceFile.getAbsolutePath() + "删除成功");
                    continue;
                }
                System.out.println(sourceFile.getAbsolutePath() + "删除失败");
            }
        }
    }

}
