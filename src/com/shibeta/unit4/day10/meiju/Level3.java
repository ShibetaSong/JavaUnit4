package com.shibeta.unit4.day10.meiju;

public enum Level3 implements LShow{
    LOW{
        @Override
        public void show() {
            System.out.println("低级别");
        }
    }, MEDIUM{
        @Override
        public void show() {
            System.out.println("中级别");
        }
    }, HIGH {
        @Override
        public void show() {
            System.out.println("高级别");
        }
    }

}

interface LShow {
    void show();
}
