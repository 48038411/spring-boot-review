package com.soft1851.springboot.schedule.task;

import com.soft1851.springboot.schedule.repository.CronRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-14 19:48
 */
//@Component
public class Task1 {
    @Resource
    private CronRepository cronRepository;
    private int count = 0;
//    String cron1 = cronRepository.findCronByCronIdEquals(1).getCron();
//    final static String CRONS = cron1;
    /**
     * 设置process()每隔五秒执行一次，并统计执行的次数
     */
    @Scheduled(cron = "0")
    private void process(){
        System.out.println("this is scheduler task running" + (count++));
    }
}
