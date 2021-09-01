package com.shibeta.unit4.day08.Demo1;

import java.util.ArrayList;

public class Debug {
    // DEBUG 断点调试
    // 步过 单步跳过 F8
    // 步入(跳入方法) 强制步入(无论是否内置方法均跳入)
    static ArrayList<String> data = new ArrayList<>();
    public static void main(String[] args) {
        int count = 10;
        for (int i=0; i<10; i++) {
            count ++;
            data.add("item" + i);
        }
        for (int i=0; i<data.size(); i++) {
            count --;
            System.out.println(data.remove(i));
        }
    }
}
