package com.shibeta.unit4.day06.connectionOfDXC;

public class Demo1 {
    /**
     * 多线程通信问题
     * 生产者与消费者问题
     */
    public static void main(String[] args) {
        Food f = new Food();
        new Cook(f).start();
        new Waiter(f).start();
    }

    static class Cook extends Thread{
        private Food f;
        public Cook(Food f) {
            this.f = f;
        }

        @Override
        public void run() {
            for (int i=0; i<100; i++) {
                if (i%2 == 0) {
                    f.setNameAndTaste("老干妈小米粥", "一言难尽");
                } else {
                    f.setNameAndTaste("煎饼果子", "甜辣味");
                }
            }
        }
    }

    static class Waiter extends Thread{
        private Food f;
        public Waiter(Food f) {
            this.f = f;
        }
        @Override
        public void run() {
            for (int i=0; i<100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                f.get();

            }
        }
    }

    static class Food {
        private String name;
        private String taste;

        // true: 可以生产
        private boolean flag = true;
        public synchronized void setNameAndTaste(String name, String taste) {
            if (!flag) {
                return;
            }
            this.name = name;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.taste = taste;
            this.flag = false;
            this.notifyAll();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void get() {
            if (flag) {
                return;
            }
            System.out.println("服务员端走的菜：" + this.name + ", 味道: " + this.taste);
            flag = true;
            this.notifyAll();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
