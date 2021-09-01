package com.shibeta.unit4.day10.zhujie;

import java.lang.annotation.Retention;

public class Demo2 {
 /*
 元注解 作用在其他注解的注解
 @Retention 标识这个注解怎么保存，是只在代码中还是编入Class文件中
 @Documented 标注注解是否包含在用户文档中 javadoc
 @Target 标注这个注解应该是哪种Java成员
 @Inherited 标记这个注解是自动继承的（子类继承父类注解）


 自定义注解
    至少一个ElementType(作用范围)
    一个RetentionPolicy(持久策略)
    定义格式:
        @interface 自定义注解名 {}
    注解中的每一个方法，实际是声明的注解配置参数
    方法的名称，就是配置参数的名称
    方法的类型，就是参数的类型
    使用注解时，传递单个参数默认传到value中
    如果只有一个参数，一般命名为value
    在方法后 + default 可以设置默认值
    注解元素必须要有值，定义时经常使用空字符串、0作为默认

  */

}
