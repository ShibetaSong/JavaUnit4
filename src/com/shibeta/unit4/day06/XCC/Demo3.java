package com.shibeta.unit4.day06.XCC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo3 {
    /**
     * 定长线程池
     * 1、判断线程池是否存在空闲线程
     * 2、存在则使用
     * 3、不存在且线程池未满，则创建线程并放入线程池，然后使用
     * 4、不存在且线程池已满，等待线程池
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"锄禾日当午");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+"锄禾日当午");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
        service.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"锄禾日当午");
                    }
                });

    }
}
