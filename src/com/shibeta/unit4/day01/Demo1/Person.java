package com.shibeta.unit4.day01.Demo1;

public class Person<A> {
    private String name;
    private int age;
    private A data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public A getData() {
        return data;
    }

    public void setData(A data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", data=" + data +
                '}';
    }
}
