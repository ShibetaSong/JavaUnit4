package com.shibeta.unit4.day06.safetyOfDXC;

public class Demo2 {
    /**
     * 线程同步: synchronized
     * @param args
     */
    public static void main(String[] args) {
        // 线程不安全
        // 解决方法1. 同步代码块
        // 格式：  synchronized(锁对象) {
        //
        // }
        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Ticket implements Runnable {
        private final Object o = new Object();
        // 票数
        private int count = 100;
        @Override
        public void run() {

            while (true) {
                synchronized (o) {
                    if (count<=0) {
                        break;
                    }
                    System.out.println("正在准备卖票");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"出票成功，余票" + count);
                }
            }
        }
    }
}
