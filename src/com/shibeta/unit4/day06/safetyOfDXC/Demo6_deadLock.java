package com.shibeta.unit4.day06.safetyOfDXC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo6_deadLock {
    public static void main(String[] args) {
        // 线程死锁
        Culprit c = new Culprit();
        Police p = new Police();
        new MyThread(c, p).start();
        c.say(p);
    }

    static class MyThread extends Thread {
        private Culprit c;
        private Police p;
        public MyThread(Culprit c, Police p) {
            this.c = c;
            this.p = p;
        }

        @Override
        public void run() {
            p.say(c);
        }
    }

    static class Culprit {
        public synchronized void say(Police p) {
            System.out.println("罪犯: 你放了我，我放人质");
            p.rep();
        }

        public synchronized void rep() {
            System.out.println("罪犯被放走了，也放走了人质");
        }
    }

    static class Police {
        public synchronized void say(Culprit c) {
            System.out.println("警察:　你放了人质，我放过你");
            c.rep();
        }

        public synchronized void rep() {
            System.out.println("警察救了人质，但罪犯跑了");
        }
    }
}
