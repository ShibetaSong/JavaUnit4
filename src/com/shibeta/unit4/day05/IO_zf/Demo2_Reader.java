package com.shibeta.unit4.day05.IO_zf;

import java.io.FileReader;
import java.io.IOException;

public class Demo2_Reader {
    public static void main(String[] args) throws IOException {
        // Reader
        FileReader fr = new FileReader("d://haha/1.txt");
//        while (true) {
//            int c = fr.read();
//            if (c == -1) {
//                break;
//            }
//            System.out.println((char) c);
//        }
        char[] chars = new char[100];
        int len = fr.read(chars);
        String text = new String(chars, 0, len);
        System.out.println(text);
        System.out.println(text.length());
        fr.close();

    }
}
