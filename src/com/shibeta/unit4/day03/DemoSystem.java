package com.shibeta.unit4.day03;

import java.lang.System;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author Shibeta
 */
public class DemoSystem {
    public static void main(String[] args) {
        // currentTimeMillis() 以毫秒为单位返回当前时间
        // arraycopy(原数组, 原数组开始位, 目标数组, 目标数组起始位置, 传递数量)

        System.out.println(System.currentTimeMillis());
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(d.format(System.currentTimeMillis()));

        int[] i = {123, 1234, 12345, 123456};
        int[] m = new int[10];
        System.arraycopy(i, 0, m, 1, 4);
        System.out.println(Arrays.toString(m));


    }
}
