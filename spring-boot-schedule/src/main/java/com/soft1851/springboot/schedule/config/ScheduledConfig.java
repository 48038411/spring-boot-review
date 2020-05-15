package com.soft1851.springboot.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 描述:
 *多线程执行定时任务
 * @author：Guorc
 * @create 2020-05-15 13:08
 */
@Configuration
public class ScheduledConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(setTaskExecutors());
    }
    @Bean
    public Executor  setTaskExecutors(){
        //创建一个基本大小为3的线程池
        return Executors.newScheduledThreadPool(3);
    }
}
