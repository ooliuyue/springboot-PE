package com.ooliuyue.springboottask.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Auther: ly
 * @Date: 2019/1/2 17:12
 */
@Component
public class SpringTaskDemo {

    private static final Logger log = LoggerFactory.getLogger(SpringTaskDemo.class);

    @Async //代表该任务可以进行异步工作，由原本的串行改为并行
    @Scheduled(cron = "0/1 * * * * *") //定时任务的核心
    public void scheduled1() throws InterruptedException {
        Thread.sleep(3000);
        log.info("scheduled1 每1秒执行一次 ：{}", LocalDateTime.now());
    }
}
