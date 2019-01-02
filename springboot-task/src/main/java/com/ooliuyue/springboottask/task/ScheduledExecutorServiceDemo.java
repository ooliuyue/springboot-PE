package com.ooliuyue.springboottask.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: ly
 * @Date: 2019/1/2 16:22
 */

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(10);
        scheduledExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
            //3秒后每秒执行一次
        },3,3, TimeUnit.SECONDS);

    }


}
