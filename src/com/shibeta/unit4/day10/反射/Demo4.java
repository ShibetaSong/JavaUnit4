package com.shibeta.unit4.day10.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo4 {
    /*
    getMethod(name, 参数class)
    getMethods()

    getDeclaredMethod()
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 面向未来编程

        
        // 加载类
        Class<?> c1 = Class.forName("com.shibeta.unit4.day10.反射.Person2");
        // 获取类构造方法
        Constructor<?> c = c1.getConstructor();
        // 创建对象
        Object o = c.newInstance();
        // 获取类的方法
        Method setName = c1.getMethod("setName", String.class);

        Method setAge = c1.getDeclaredMethod("setAge", int.class);
        // 忽略权限检查
        setAge.setAccessible(true);

        // 参数1 哪个对象要执行setName方法
        // 参数2 调用方法时传递的参数 0-n个
        setName.invoke(o, "zhangsan");
        setAge.invoke(o, 18);

        System.out.println(o);

    }
}
