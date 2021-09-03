package com.shibeta.unit4.day10.反射;

public class Person2 {
    private int age;
    private String name;

    public Person2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private Person2(String name) {
        this.age = 88;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Person2() {
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
