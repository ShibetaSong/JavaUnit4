package com.shibeta.unit4.day06.XCC;

public class Demo6_Lambda {
    /**
     * lambda
     *  函数式编程思想
     */
    public static void main(String[] args) {
        /* 冗余的Runnable代码 */
        // 1. 创建Runnable类
//        MyRunnable r = new MyRunnable();
//        Thread t = new Thread(r);
//        t.start();

        // 2. 匿名内部类
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("锄禾日当午");
//            }
//        });

        Thread t = new Thread(() -> {
            System.out.println("锄禾日当午");
            System.out.println("汗滴禾下土");
        });
        t.start();
    }

//    static class MyRunnable implements Runnable {
//        @Override
//        public void run() {
//            System.out.println("锄禾日当午");
//        }
//    }
}
