package com.shibeta.unit4.DXC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo2_Callable {
    /**
     * Callable 接口
     * 1、实现方法（泛型）
     * 2、创建FutureTask对象，传入第一步编写的Callable对象
     * 3、通过Thread启动线程
     *
     *  FutureTask
     *      get()   如果需要等待计算完成，然后检索结果
     *      get(long timeout, TimeUnit unit) 给定超时时间
     */
    public static void main(String[] args) {
        Callable<Integer> c = new MyCallable();
        FutureTask<Integer> task = new FutureTask<>(c);
        new Thread(task).start();
        try {
            Integer j = task.get();
            System.out.println("返回值为: "+j);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        for (int i=0; i<10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
//            Thread.sleep(3000);
            for (int i=0; i<10; i++) {
                Thread.sleep(10);

                System.out.println(i);
            }
            return 100;

        }
    }
}
