package com.shibeta.unit4.day06.safetyOfDXC;

public class Demo3 {
    public static void main(String[] args) {
        // 解决方案2. 同步方法

//        Runnable run = new Ticket();
        new Thread(new Ticket()).start();
        new Thread(new Ticket()).start();
        new Thread(new Ticket()).start();
    }

    static class Ticket implements Runnable {
        // 票数
        private int count = 10;
        @Override
        public void run() {
            while (true) {
                boolean flag = sale();
                if (!flag) {
                    break;
                }

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
