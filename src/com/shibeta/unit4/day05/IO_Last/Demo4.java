package com.shibeta.unit4.day05.IO_Last;

import java.io.*;

public class Demo4 {
    public static void main(String[] args) throws FileNotFoundException {
        // try-with-resources   自动调用close方法
        // 1.7 之前
//        FileReader fr = null;
//        try {
//            fr = new FileReader("d://haha/1.txt");
//            int c = fr.read();
//            System.out.println((char) c);
//            fr.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        // 1.7
        // 能在try括号中生成的对象必须拥有close方法（实现closeable接口）
//        try(FileReader fr = new FileReader("d://haha/1.txt")) {
//            int c = fr.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // JDK 9
//        FileReader fr = new FileReader("d://haha/1.txt");
//        PrintWriter pw = new PrintWriter("d://haha/1.txt");
//        try(fr; pw) {
//            int c = fr.read();
//            System.out.println((char) c);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        CloseDemo d = new CloseDemo();
        try(d) {

        } catch (Exception e) {

        }
    }

    static class CloseDemo implements Closeable{
        @Override
        public void close() throws IOException {
            System.out.println("close被调用");
        }
    }
}
