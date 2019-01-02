package com.ooliuyue.springboottask.task;

        import java.time.LocalDateTime;
        import java.util.Timer;
        import java.util.TimerTask;

/**
 * 基于Timer实现的定时调度，不推荐
 * @Auther: ly
 * @Date: 2019/1/2 15:53
 */

public class TimerDemo{
    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务" + LocalDateTime.now());
            }
        };
        Timer timer = new Timer();
        //在3秒后执行timerTask中的run方法,后面每5秒跑一次
        timer.schedule(timerTask,3000,5000);

    }
}
