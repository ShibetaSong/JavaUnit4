package com.shibeta.unit4.day01.Demo1;

public class Demo {
//    /**
//     * 右边的String可以不写
//     */
//    Person<String> p = new Person<String>();
    public static void main(String[] args) {
        String[] arg = new String[10];
        print(123);
        print("123");
        print(arg);
    }

    public static <A> void print(A a) {
        System.out.println(a);
    }
}
