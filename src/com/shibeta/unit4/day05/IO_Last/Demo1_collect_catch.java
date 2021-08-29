package com.shibeta.unit4.day05.IO_Last;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1_collect_catch {
    // 收集异常日志
    public static void main(String[] args) throws IOException {
        try {
            String s = null;
            s.toString();
        } catch (Exception e) {
            FileWriter fw = new FileWriter("d://haha/异常.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            pw.println(sdf.format(new Date()));
            e.printStackTrace(pw);
            pw.close();
            fw.close();
        }
    }
}
