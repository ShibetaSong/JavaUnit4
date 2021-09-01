package com.shibeta.unit4.day10.zhujie;

import java.lang.annotation.*;

public class diy {
    @MyAnnotation("zs")
    public static void main(String[] args) {

    }
}

// 注解是否包含在文档中
@Documented
// 持久策略
@Retention(RetentionPolicy.RUNTIME)
// 作用类型
@Target({ElementType.TYPE, ElementType.METHOD})
// 可以继承
@Inherited
@interface MyAnnotation {

    String value();
    int num() default 0;
}
