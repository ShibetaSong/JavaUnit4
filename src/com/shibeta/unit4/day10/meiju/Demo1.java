package com.shibeta.unit4.day10.meiju;

public class Demo1 {
    /*
     * 枚举 enum 描述同一种类型的常量
     * 把一种类型的有限数量的同类常量放在一起
     * 在枚举类型中定义的常量是该枚举类型的实例
     * JDK1.5 之前使用枚举：
     *      先创建一种类型，私有化构造方法(使外部无法创建常量)
     *      在类型中创建常量
     *
     * 枚举类 Enum 类(抽象类，所有枚举类都继承此类)
     * int compareTo(E o) 比较此枚举与指定对象的顺序
     * boolean equals()
     * Class<?> getDeclaringClass() 返回与此枚举常量的枚举类型相对应的Class对象
     * String name()
     * int ordinal() 枚举常量的序数，从0开始
     * Class<T> Enum.valueOf(Class<T> enumType, String name) 返回某枚举类中的名称为name的常量
     *
     * 枚举实现接口 可以给每一个常量对象添加接口的实现
     * 常量对象{重写方法}
     *
     * 注意事项:
     *      一旦定义了枚举，最好不要妄图修改里面的值，除非修改是必要的
     *      枚举类默认继承的是java.lang.Enum而不是Object类
     *      枚举类不能有子类，应为枚举类默认被final修饰
     *      只能有private构造方法
     *      switch中使用枚举时，直接使用常量名，不用携带类名
     *      不能定义name属性，因为自带
     *      不要为枚举中的属性提供set方法，因为不符合枚举的初衷
     */

    public static void main(String[] args) {
//        System.out.println(Level.LOW.getLevelValue());
        System.out.println(Level3.LOW.compareTo(Level3.HIGH));
        System.out.println(Level3.LOW.compareTo(Level3.MEDIUM));
        System.out.println(Level3.HIGH.compareTo(Level3.MEDIUM));
        System.out.println(Level2.LOW.ordinal());
        Level2 x = Enum.valueOf(Level2.class, "HIGH");
        System.out.println(x.name());

        Level3.HIGH.show();
    }
}
