package com.shibeta.unit4.day03;

import java.math.BigDecimal;

public class Demo_BigDecimal {
    public static void main(String[] args) {
        // float和double的运算误差
        System.out.println(0.1 + 0.2);

        BigDecimal b1 = new BigDecimal("0.1");
        BigDecimal b2 = new BigDecimal("0.2");

        BigDecimal b3 = b1.add(b2);
        b3 = b1.subtract(b2);
        double b4 = b3.doubleValue();
        int b5 = b3.intValue();
        System.out.println(b3);
        System.out.println(b4);
    }

}
