package com.shibeta.unit4.day02;

import java.util.Objects;

/**
 * Objects 类库
 */
public class Demo {
    public static void main(String[] args) {
        Person p1 = null;
        Person p2 = new Person();

        /*
        空指针异常
        System.out.println(p1.equals(p2))
         */
        System.out.println(Objects.equals(p1, p2));
        System.out.println(Objects.isNull(p1));
        System.out.println(Objects.nonNull(p1));
        System.out.println(Objects.requireNonNull(p1));
    }
}
