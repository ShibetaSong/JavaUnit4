package com.shibeta.unit4.day06.XCC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo4 {
    /**
     * 单线程线程池
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "锄禾日当午");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "锄禾日当午");
            }
        });

    }

}
