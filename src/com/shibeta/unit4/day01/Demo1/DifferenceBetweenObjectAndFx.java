package com.shibeta.unit4.day01.Demo1;

public class DifferenceBetweenObjectAndFx {
    public static void main(String[] args) {
        A<String> a = new A<>();
        B b = new B();

        String result1 = a.doSomething("参数是String");
        String result2 = (String) b.doSomething("参数是String");
    }
}

class A<T> {
    public T doSomething(T t) {
        return t;
    }
}

class B {
    public Object doSomething(Object obj) {
        return obj;
    }
}