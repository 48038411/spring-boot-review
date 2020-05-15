package com.soft1851.springboot.schedule.task;

import com.soft1851.springboot.schedule.repository.CronRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-15 20:05
 */
@Slf4j
@Component
public class AutoTask implements SchedulingConfigurer {
    @Resource
    protected CronRepository cronRepository;
    @Bean
    public Executor setTaskExecutors(){
        return Executors.newScheduledThreadPool(3);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(this::process,
                triggerContext -> {
            String cron = cronRepository.findCronByCronIdEquals(1).getCron();
            log.info(cron);
            if (cron.isEmpty()){
                log.info("cron为空");
            }
            return new CronTrigger(cron).nextExecutionTime(triggerContext);
                });
    }
    private void process(){
        log.info("从数据库读取cron");
    }
}
