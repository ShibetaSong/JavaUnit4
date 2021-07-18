package com.shibeta.unit4.day06.safetyOfDXC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo4 {
    /**
     * 显式锁和隐式锁的区别？
     *
     */
    public static void main(String[] args) {
        // 解决方案3. 显式锁 Lock 子类 ReentrantLock
        // 同步代码块和同步方法 都属于隐式锁

        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Ticket implements Runnable {
        // 票数
        private int count = 10;
        // 显式锁
        private final Lock l = new ReentrantLock();

        @Override
        public void run() {
            while (true) {
                l.lock();
                boolean flag = sale();
                if (!flag) {
                    break;
                }
                l.unlock();

            }

        }

        public synchronized boolean sale() {
            // 锁对象
            // 非static: this
            // static: 类名.class (字节码文件)
            if (count<=0) {
                return false;
            }
            System.out.println("正在准备卖票");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println(Thread.currentThread().getName()+"出票成功，余票" + count);
            return true;
        }
    }
}
