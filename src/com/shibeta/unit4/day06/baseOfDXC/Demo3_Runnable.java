package com.shibeta.unit4.day06.baseOfDXC;

public class Demo3_Runnable {
    /**
     * 实现 Runnable与继承 Thread 相比，有如下优势：
     *  1. 通过创建任务，然后给线程分配的方式来实现多线程，更适合多个线程同时执行相同任务的情况
     *  2. 可以避免单继承所带来的局限性（Java中只能单继承）
     *  3. 任务与线程本身分离，提高了程序的健壮性
     *  4. 后续学习的线程池技术，接受Runnable类型的任务，不接受Thread类型的线程
     */
    public static void main(String[] args) {
        // 实现Runnable

        // 创建一个任务对象
        MyRunnable m = new MyRunnable();
        // 创建一个线程，并为其分配一个任务
        Thread t = new Thread(m);

        t.start();
        for (int i=0; i<10;i++) {
            System.out.println("疑是地上霜" + i);
        }
    }
}
