//package com.shibeta.unit4.day01.Demo1;
//
//public class Demo2 {
//    public static void main(String[] args) {
//        Apple apple = new Apple();
//        Plate<Apple> p = new Plate<>();
//        p.setData(apple);
//    }
//}
//
//interface Fruit {}
//class Apple implements Fruit {
//    private String color;
//    private String taste;
//    private int mg;
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public String getTaste() {
//        return taste;
//    }
//
//    public void setTaste(String taste) {
//        this.taste = taste;
//    }
//
//    public int getMg() {
//        return mg;
//    }
//
//    public void setMg(int mg) {
//        this.mg = mg;
//    }
//}
//
//class Plate<T extends Fruit> {
//    private T data;
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//}