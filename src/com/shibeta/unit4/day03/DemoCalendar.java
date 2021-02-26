package com.shibeta.unit4.day03;


import java.util.Calendar;
import java.util.Date;

/**
 * @author Shibeta
 */
public class DemoCalendar {
    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();

        // 原理是通过下标操作数组，YEAR、MONTH等常量都是下标
        System.out.println(c1.get(Calendar.YEAR));
        System.out.println(c1.get(Calendar.DAY_OF_YEAR));
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));

        c1.set(Calendar.YEAR, 2022);
        System.out.println(c1.get(Calendar.YEAR));

        c1.add(Calendar.YEAR, 1);
        System.out.println(c1.get(Calendar.YEAR));

        // 计算机中的月份 0-11
        System.out.println(c1.get(Calendar.MONTH));

        // getTime : 获取日历时间表示的Date对象

        Date d = c1.getTime();

        // getActualMaximum 获取最大值

        System.out.println(c1.getActualMaximum(Calendar.MONTH));
        System.out.println(c1.getActualMaximum(Calendar.MONTH));
        System.out.println(c1.getActualMaximum(Calendar.DAY_OF_YEAR));
        System.out.println(c1.getActualMaximum(Calendar.DAY_OF_MONTH));

        c1.set(Calendar.MONTH, 3);
        System.out.println(c1.get(Calendar.MONTH));
        System.out.println(c1.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

}
