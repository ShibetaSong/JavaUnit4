package com.shibeta.unit4.day10.zhujie;

public class Demo {
    /*
    注解 Annotation 又称Java标注，是JDK5引入的一种注释机制
    Java中的类、方法、变量、参数、包等都可以被标注。
    编译器生成类文件时，标注可以被嵌入到字节码中。
    Java虚拟机可以保留标注内容
    主要用于：
        编译格式检查
        反射中解析
        生成帮助文档
        跟踪代码依赖等

    内置注解:
    @Override 重写
    @Deprecated 废弃(已不用)
    @SafeVarargs 忽略任何使用参数为范型变量的方法调用产生的警告
    @FunctionalInterface 函数式接口 Java8开始支持
    @Repeatable 标识某注解可以在同一个声明上使用多次
    @SuppressWarnings 抑制编译时的警告信息, 可以加在任何地方
        @SuppressWarnings("unchecked") 抑制单类型警告
        @SuppressWarnings("unchecked", "rawtypes") 抑制多类型警告
        @SuppressWarnings("all") 抑制所有类型警告


     */
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge2(2);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Person {
    private int age;

    public int getAge() {
        return age;
    }

    /**
     * 此方法已经被废弃，请通过setAge2来操作
     * @param age int age
     */
    @Deprecated
    public void setAge(int age) {
        this.age = age;
    }

    public void setAge2(int age) {
        if (age < 0 || age > 150) {
            throw new RuntimeException("年龄不合理");
        }
        this.age = age;
    }
}

@SuppressWarnings("all")
class Person2 {

}
