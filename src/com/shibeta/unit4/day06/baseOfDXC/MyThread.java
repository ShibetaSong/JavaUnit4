package com.shibeta.unit4.day06.baseOfDXC;

public class MyThread extends Thread {

    /**
     * run方法就是线程要执行的任务方法
     */
    @Override
    public void run() {
        // 这里的代码 就是一条新的执行路径
        // 这个执行路径的触发方式，不是调用run方法，而是通过thread对象的
        // start() 来启动任务

        for (int i=0; i<10; i++) {
            System.out.println("锄禾日当午" + i);
        }
    }
}
