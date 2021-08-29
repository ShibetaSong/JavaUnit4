package com.shibeta.unit4.day06.XCC;

public class Lambda {
    public static void main(String[] args) {
//        print(new MyMath() {
//            @Override
//            public int sum(int x, int y) {
//                return x + y;
//            }
//        }, 100, 200);
        print((int x, int y) -> x + y - 1, 100, 200);
    }

    public static void print(MyMath m, int x, int y) {
        int num = m.sum(x, y);
        System.out.println(num);
    }

    static interface MyMath {
        int sum(int x, int y);

    }
}
