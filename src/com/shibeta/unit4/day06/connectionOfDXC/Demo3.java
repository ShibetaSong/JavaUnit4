package com.shibeta.unit4.day06.connectionOfDXC;

import java.util.TreeMap;
import java.util.concurrent.*;

public class Demo3 {
    /**
     * Callable 可实现带返回值的多线程
     * get()    等待计算完成后获取结果
     * get(long timeout) 延时等待
     * cancel()
     */
    public static void main(String[] args) {
        Callable<String> c = new MyCallable();
        FutureTask<String> task = new FutureTask<>(c);
        Thread t = new Thread(task);
        t.start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
            return null;
        }
    }
}
