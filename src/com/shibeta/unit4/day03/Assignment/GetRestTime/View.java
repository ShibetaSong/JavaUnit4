package com.shibeta.unit4.day03.Assignment.GetRestTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class View {
    private static Scanner input=new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        new Dao().print(YearsInput(), MonthInput());

    }
    public void Wellcome(){
        System.out.println("欢迎");
    }

    int Menu(){
        System.out.println("按1继续");
        //全局使用nextLine，可避免输入冲突，更好的去接收各种输入数据
        String choose=input.nextLine();
        int result=-1;
        try {
            result=Integer.parseInt(choose);
        }catch (NumberFormatException e){
        }
        return result;
    }
    /**
     * 输入年
     */
    static int YearsInput(){
        System.out.println("请输入年份");
        String text=input.nextLine();
        int year=-1;
        try {
            year=Integer.parseInt(text);
        }catch (NumberFormatException e){
        }
        //判定输入是否在2020往后
        if (year<2020){
            System.out.println("输入年份不得小于2020");
            return YearsInput();
        }
        return year;
    }
    /**
     * 输入月
     */
    static int MonthInput(){
        System.out.println("请输入月份");
        String text=input.nextLine();
        int month=-1;
        try {
            month=Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if (month<0&&month>11){
            System.out.println("请重新输入月份");
            return MonthInput();
        }
        return month;
    }
}



class Dao {
    private Calendar calendar=Calendar.getInstance();
    /**
     * 打印日历
     */
    public void print(int year , int month) throws ParseException {
        Calendar cl = Calendar.getInstance();
        cl.clear();
        cl.set(Calendar.YEAR, year);
        cl.set(Calendar.MONTH, month);
        int day = 0;
        int weekend = 0;
        //在循环中调用方法挨个打印
        for (int i = 1; i <= cl.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            cl.set(Calendar.DAY_OF_MONTH, i);
            int a = cl.get(Calendar.DAY_OF_WEEK);
            if (i == 1) {
                for (int j = 1; j < a; j++) {
                    System.out.print("\t\t");
                }
            }
            int[] d = restDay(cl,i,a,day,weekend);
            day = d[0];
            weekend = d[1];
        }
        System.out.println();
        System.out.println("本月休息天数有：" + day + "天");
        System.out.println("本月轮到周末休息天数是：" + weekend + "天");
    }
    /**
     * 计算目标时间与休息日相隔多久并判定是否是周末
     *
     */
    int[] restDay(Calendar cl, int i, int a, int day, int weekend) throws ParseException {
        long nonRestDay = 4*24*60*60*1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date day1 = sdf.parse("2020-02-02 00:00:00");
        StringBuilder sb = new StringBuilder();
        //方法在上方print中循环打印，如果不是周末那么正常输出，如果是周周末那么标上【】
        if ((cl.getTime().getTime() - day1.getTime()) % nonRestDay == 0 && (cl.getTime().getTime() - day1.getTime()) >= 0) {
            sb.append("[");
            sb.append(i);
            sb.append("]");
            day++;
            if (a == 1 || a == 7) {
                weekend++;
            }
        } else {
            sb.append(" ");
            sb.append(i);
        }
        if (a == 7) {
            System.out.println(sb.toString());
        } else {
            sb.append("  \t");
            System.out.print(sb.toString());
        }

        return new int[] {day,weekend};
    }
}