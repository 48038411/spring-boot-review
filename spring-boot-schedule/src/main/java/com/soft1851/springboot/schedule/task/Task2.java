package com.soft1851.springboot.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-14 19:52
// */
//@Component
public class Task2 {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

    /**
     * 每隔三秒执行一次
     */
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime(){
        System.out.println(Thread.currentThread().getName()+"现在时间： "+ dtf.format(LocalDateTime.now()));
    }

    /**
     * fixedDelay：固定延时
     */
    @Scheduled(fixedDelay = 2000)
    public void reportCurrentTime2(){
        System.out.println(Thread.currentThread().getName()+ "现在时间："+dtf.format(LocalDateTime.now()));
    }

    /**
     * 第一次延迟三秒后执行，之后按照fixedDelay的规则每两秒执行一次
     */
    @Scheduled(initialDelay = 3000,fixedDelay = 2000)
    public void reportCurrentTime3(){
        System.out.println(Thread.currentThread().getName()+ "现在时间："+ dtf.format(LocalDateTime.now()));
    }
}
