package com.shibeta.unit4.day03;

import java.util.Date;

public class DemoDate {
    public static void main(String[] args) {
        // 创建一个当前时间的Date
        Date date = new Date();


        long time = date.getTime()-(24*60*60*1000);

        Date date2 = new Date(time);
        System.out.println(date);
        System.out.println(date2);
        System.out.println(date2.getTime());

        System.out.println(date.getTime()/1000/60/60/24/365);
    }

}
