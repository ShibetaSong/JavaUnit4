package com.shibeta.unit4.day04.list_inte;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListLearn {
    public static void main(String[] args) {
        // 使用的是数组结构，增删操作慢，查找快
        /*
        无参构造方法 ArrayList() // 默认初始容量为10
        一参构造方法 ArrayList(int initialCapacity) // 指定初始容量
        Collection构造方法 ArrayList(Collection<? extends E> c) // 按照集合的迭代器返回的顺序构造一个包含指定集合元素的列表

         */
        ArrayList<Integer> data = new ArrayList<>(); //长度为0
        data.add(123); // 扩容10
        data.add(3);
        System.out.println(data.get(1));
    }
}
