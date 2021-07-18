package com.shibeta.unit4.day06.baseOfDXC;

public class Demo4_getName {
    /**
     * Thread.currentThread() 返回当前线程对象
     */
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t = new Thread(new myRunnable());
        t.start();

    }
    static class myRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
