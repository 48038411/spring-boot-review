package com.soft1851.springboot.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-14 19:48
 */
//@Component
public class Task1 {
    private int count = 0;

    /**
     * 设置process()每隔五秒执行一次，并统计执行的次数
     */
    @Scheduled(cron = "*/5 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task running" + (count++));
    }
}
