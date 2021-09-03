package com.shibeta.unit4.day10.反射;

public class Person {
    public static void main(String[] args) throws ClassNotFoundException {
        // 第一种方式，通过(包名).类名.class 加载类到内存
        Class<Person> c1 = Person.class;
        System.out.println(c1);

        // 第二种方式 通过类的对象获取类的信息
        Person p = new Person();
        Class<?> c2 = p.getClass();
        System.out.println(c2);
//        System.out.println(c1 == c2);


        // 三 Class.forName(包名+类名) 可以在类不存在的时候使用
        Class<?> c3 = Class.forName("com.shibeta.unit4.day10.反射.Person");
        System.out.println(c3);
        System.out.println(c1 == c2 && c1 == c3);
    }
}
