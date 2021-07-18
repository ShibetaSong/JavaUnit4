package com.shibeta.unit4.day06.safetyOfDXC;

public class Demo1 {
    public static void main(String[] args) {
        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Ticket implements Runnable {
        // 票数
        private int count = 10;
        @Override
        public void run() {
            while (count>0) {
                System.out.println("正在准备卖票");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println("出票成功，余票" + count);
            }

        }
    }
}
