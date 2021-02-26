package com.shibeta.unit4.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoDateFormat {
    public static void main(String[] args) throws ParseException {
        /**
         * y : 年
         * M : 月
         * d : 日
         * H : 时
         * m : 分
         * s : 秒
         *
         * 2021年2月8日 15时27分 50
         */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm ss");
        // format: 将date对象 转换为字符串
        System.out.println(format.format(new Date()));
        // parse: 将字符串 转换为date对象
        Date date = format.parse("2021-2-08 15:28 52");
        System.out.println((new Date().getTime() - date.getTime())/1000/60);
    }

}
