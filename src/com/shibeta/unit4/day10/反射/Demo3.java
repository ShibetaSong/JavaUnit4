package com.shibeta.unit4.day10.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo3 {
    /*
    通过class对象获取类构造方法
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person2> pClass = (Class<Person2>) Class.forName("com.shibeta.unit4.day10.反射.Person2");
        // 找到无参构造方法
        Constructor<Person2> c1 = pClass.getConstructor();
        // 使用无参构造方法创建对象（新实例）
        Person2 p = c1.newInstance();
        System.out.println(p);

        // 找到包含String name 和 int age的全参构造方法
//        Constructor<Person2> c2 = pClass.getConstructor(new Class[] {String.class, int.class});
        Constructor<Person2> c2 = pClass.getConstructor(int.class, String.class);
        Person2 p2 = c2.newInstance(18, "张三");
        System.out.println(p2);

        // 获取所有权限的单个构造方法
        Constructor<Person2> c3 = pClass.getDeclaredConstructor(String.class);
        // 忽略权限检查
        c3.setAccessible(true);
        Person2 p3 = c3.newInstance("李四");
        System.out.println(p3);

        // 获取构造方法数组
        pClass.getConstructors();

        // 获取所有权限的构造方法数组
        pClass.getDeclaredConstructors();



    }

}
