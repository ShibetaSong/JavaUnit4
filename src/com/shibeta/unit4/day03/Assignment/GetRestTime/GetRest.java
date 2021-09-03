package com.shibeta.unit4.day03.Assignment.GetRestTime;


import java.util.Calendar;
import java.util.Scanner;

public class GetRest {
    static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // 创建第一个休息日 日历与查询日期日历
        Calendar firstRestDay = Calendar.getInstance();
        Calendar curDate = Calendar.getInstance();

        // 设置第一个休息日的年份与当前年份
        int firstYear = 2020;
        int curYear;

        while (true) {
            System.out.print("请输入年份(E以退出): ");
            try {
                String str = input.nextLine();
                if (str.equals("E")) {
                    break;
                }
                curYear = Integer.parseInt(str);

                System.out.print("请输入月份: ");

                // 设置日历属性
                setDate(firstRestDay, firstYear, 2, 2);
                setDate(curDate, curYear, Integer.parseInt(input.nextLine()), 1);
            } catch (NumberFormatException e) {
                System.out.println("输入有误，重新输入");
                continue;
            }
            System.out.println("\n当前月份的首日与首次休息日相隔 "+getBetweenDay(firstRestDay, curDate)+"天");
            // 输出日历
            show(curDate, getBetweenDay(firstRestDay, curDate));
        }
    }

    /**
     * 获取两个日期的天数差
     * @param old older Calendar
     * @param cur nearlier Calendar
     * @return int, 天数差
     */
    public static int getBetweenDay(Calendar old, Calendar cur) {
        // 获取首个休息日的天序、查询日的天序、单年相差天数
        int firstDayOfYear = old.get(Calendar.DAY_OF_YEAR);
        int curDayOfYear = cur.get(Calendar.DAY_OF_YEAR);
        int dayBetween = curDayOfYear - firstDayOfYear;

        // 总相差天数 = 查询日天序 + 相隔全年天数 - 首个休息日天序
        // 如：查询日 2020年2月, 天序为33, 休息日 2019.2.2 天序为32, 2019全年天数为365天
        // 则相隔天数为 33 - (365-32)
        for (int i=old.get(Calendar.YEAR); i<cur.get(Calendar.YEAR); i++) {
            Calendar c =  Calendar.getInstance();
            c.set(Calendar.YEAR, i);
            dayBetween += c.getActualMaximum(Calendar.DAY_OF_YEAR);
        }

        return dayBetween;
    }

    /**
     * 设置日期
     * @param c 日历对象
     * @param year 年
     * @param month 月
     * @param dayOfMonth 基于月份的日期(某月的第几天)
     */
    public static void setDate(Calendar c, int year, int month, int dayOfMonth) {
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
    }

    /**
     * 打印输出日历
     * @param c 日历
     * @param dayBetween 月初与首次休息日的相隔天数
     */
    public static void show(Calendar c, int dayBetween) {
        System.out.println("====================");
        System.out.println("当前日期: "+c.get(Calendar.YEAR) + "年 " + (c.get(Calendar.MONTH)+1) + "月");
        System.out.println("星期日    星期一    星期二    星期三    星期四    星期五    星期六");
        System.out.println("===========================================================");

        int restDay = 0;
        int restDayAtWE = 0;
        Calendar newC = Calendar.getInstance();
        setDate(newC, c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, 1);

        for (int i=1; i<=newC.get(Calendar.DAY_OF_MONTH); i++) {
            // (指定年月的第一天 与 首次休息日 的日期差 + 指定年月的指定日 与 第一天 的日期差) 对4求余
            // 即 指定年月日 与 首次休息日的日期差 对4求余
            boolean isRestDay = (dayBetween + i - 1) % 4 == 0;
            boolean isDayAfterRestDay =  (dayBetween + i - 1) % 4 == 1;
            boolean isFirstDayOrSunday = i == 1 || newC.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
            int curDayAtWeek = newC.get(Calendar.DAY_OF_WEEK);

            if (isFirstDayOrSunday) {
                // 每月的首日，单独输出缩进
                for (int j = 1; j < newC.get(Calendar.DAY_OF_WEEK); j++) {
                    System.out.print("         ");
                }
            }

            if (!isFirstDayOrSunday){
                // 月份字符长度
                int strLength = String.valueOf(i-1).length();

                System.out.print("   ");
                // 根据月份字符长度、是否为休息日 选择性输出不同长度的空格
                if (!isDayAfterRestDay) {
                    for (int j = 0; j < 3 + (3-strLength) ; j++) {
                        System.out.print(" ");
                    }
                } else {
                    for (int j = 0; j < 3 + (strLength==2? -1: 1-strLength) ; j++) {
                        System.out.print(" ");
                    }
                }
            }

            // 输出日期
            restDay += isRestDay? 1: 0;
            restDayAtWE += (isRestDay && (curDayAtWeek == 1 || curDayAtWeek == 7))? 1: 0;
            System.out.print(isRestDay? "["+i+"]": i);
            // 周六输出换行
            if (newC.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                System.out.println();
            }
            // 更新日期
            newC.set(Calendar.DAY_OF_MONTH, i+1);
        }

        System.out.println("\n本月休息天数有: "+ restDay + "天\n本月轮到周末休息天数是: " + restDayAtWE + "天");
        System.out.println("---------------");
    }
}
