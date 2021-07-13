package com.shibeta.unit4.day05.IO1_5;

import java.io.File;
import java.io.IOException;

/**
 * File 类对象 可以表示某个文件
 *
 * File(String pathname)
 *
 *
 * createNetFile() 仅有具有此名称的文件尚不存在时
 * getAbsolutePath() 获取绝对路径字符串
 * getPath()
 * getName()
 * getParent()
 * getParentFile()
 * length() 文件大小
 * exists() 判断文件是否存在
 * isFile()
 * isDirectory()
 * list()   获取文件夹中的所有文件对象 路径字符串
 * listFiles() 获取文件夹中的所有文件对象 对象
 * mkdir()  创建一层目录
 * mkdirs() 创建多层目录
 * renameTo(File) 移动至File对象的路径
 *
 *
 * 字段：
 *  pathSeparator   与系统相关的路径分隔符
 *  separator       名称分隔符
 */
public class io_File {

    public static void main(String[] args) throws IOException {
//        File file = new File("D://1.txt");
//        boolean flag = file.createNewFile();
//        System.out.println(flag? "成功": "失败");

//        File dir = new File("D://haha");
        //dir.mkdir();

//        File a = new File(dir, "a.txt");
        //a.createNewFile();
//        a.delete();

//        File b = new File("D://haha", "b.txt");
        //b.createNewFile();
//        b.delete();

//        File file = new File("D://haha/321.txt");
//        File newFile = new File("D://haha/123/1.txt");
//        file.renameTo(newFile);
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
    }
}
