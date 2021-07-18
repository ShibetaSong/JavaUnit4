package com.shibeta.unit4.day06.baseOfDXC;

/**
 * 用于给线程执行的任务
 * 需要搭配Thread使用
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        // 线程的任务
        for (int i=0;i<10;i++) {
            System.out.println("床前明月光" + i);
        }
    }
}
