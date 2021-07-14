package com.shibeta.unit4.day05.IO_zf;

import java.io.*;

public class Demo4_print_buffered {

    public static void main(String[] args) throws IOException {
        // 字符输出(打印流)
//        PrintStream ps = new PrintStream("d://haha/print.txt");
//        ps.println("锄禾日当午，汗滴禾下土1");
//        ps.println("锄禾日当午，汗滴禾下土2");
//        ps.println("锄禾日当午，汗滴禾下土3");

//        PrintWriter pw = new PrintWriter("d://haha/print.txt");
//        pw.println("锄禾日当午，汗滴禾下土1");
//        pw.println("锄禾日当午，汗滴禾下土2");
//        pw.println("锄禾日当午，汗滴禾下土3");
//        pw.flush();
//        pw.close();

//        FileOutputStream fos = new FileOutputStream("d://haha/print.txt");
//        PrintWriter pw = new PrintWriter(fos);
//        pw.println("321312512");
//        pw.println("321312125");
//        pw.println("321312515");
//        pw.close();

        // 缓存读取流，将字符输入流 转换为 带有缓存 可以一次读取一行的缓存字符读取流
        FileReader fr = new FileReader("d://haha/1.txt");
        BufferedReader br = new BufferedReader(fr);
        System.out.println(br.readLine());

    }

}
