package com.shibeta.unit4.day06.baseOfDXC;

public class Demo5_sleep {
    public static void main(String[] args) throws InterruptedException{
//        for (int i=0; i<10; i++) {
//            System.out.println(i);
//            // thread 的静态方法sleep
//            Thread.sleep(1000);
//        }

//        // 线程阻塞
//
//        // 线程中断
//        // 一个线程是一个独立的执行路径，它是否应该结束，应该由其自身决定
//        Thread t1 = new Thread(new MyRunnable());
//        t1.start();
//
//        for (int i=1;i<=5;i++) {
//            System.out.println(Thread.currentThread().getName() + i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        // 给线程t1添加中断标记
//        t1.interrupt();

        // 用户线程：当一个进程不包含任何存活的用户线程时，进程结束
        // 守护线程：用于守护用户线程，当最后一个用户线程结束时，所有守护线程自动死亡
        Thread t1 = new Thread(new MyRunnable());

        // 设置t1为守护线程，当主线程结束后，t1也会结束
        t1.setDaemon(true);
        t1.start();

        for (int i=1;i<=5;i++) {
            System.out.println(Thread.currentThread().getName() + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for (int i=1;i<=10;i++) {
                System.out.println(Thread.currentThread().getName() + i);
                try {
                    Thread.sleep(1000);
                    // 若检查到了中断标记，则会抛出此异常
                } catch (InterruptedException e) {
                    System.out.println("发现了中断标记，awsl");
                    return;
                }
            }
        }
    }
}
