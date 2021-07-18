package com.shibeta.unit4.day06.baseOfDXC;

public class Demo2_Thread {
    /**
     * Thread 类
     * Thread()
     * Thread(Runnable)
     * Thread(Runnable, String name)
     * Thread(String name)
     *
     * 方法
     *  getName()
     *  getId()
     *  getPriority() 获取线程优先级
     *  setPriority() 设置线程优先级   三个常量
     *  start()
     *  stop()  已过时，不安全
     *  sleep(long millis(毫秒)) 导致当前正在执行的线程休眠
     *  sleep(long millis, int nanos(纳秒))
     *  setDaemon(boolean on)   将此线程标记为 daemon线程(守护线程) 或用户线程
     *      守护线程掌握不了自己的生命，当所有用户线程死亡时，守护线程死亡。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        MyThread m = new MyThread();
        m.start();
        // Thread
        for (int i=0; i<10; i++) {
            System.out.println("汗滴禾下土" + i);
        }
    }
}

