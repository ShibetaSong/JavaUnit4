package com.shibeta.unit4.day01.Demo1;

public class Demo3_tpf {
    //    Plate<Fruit> p = new Plate<Apple>();

    /**
     * 不能将一个装着苹果的盘子，看做一个装着水果的盘子
     *
     * 限定了父类，上界限定
     */
    Plate<? extends Fruit> p = new Plate<Apple>();
    Plate<? super Apple> a = new Plate<Fruit>();
}
interface Fruit{}
class Apple implements Fruit{}
class Plate<T> {}