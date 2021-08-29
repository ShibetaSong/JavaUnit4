package com.shibeta.unit4.day06.XCC;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo5 {
    /**
     * 周期任务 定长线程池
     */
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
//        /*1. 定时执行一次
//        参数1 定时执行的任务
//        参数2 时长数字
//        参数3 时长数字的时间单位   TimeUnit的常量指定
//         */
//        service.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("锄禾日当午");
//            }
//        }, 5, TimeUnit.SECONDS);

        /*
        2.  周期性执行任务
        参数1 任务
        参数2 时长数字(第一次执行在什么时间以后)
        参数3 周期时长数字(第一次执行后，每隔多久执行一次)
        参数4 时长数字的单位
         */
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("汗滴禾下土");
            }
        }, 5, 1, TimeUnit.SECONDS);

    }
}
