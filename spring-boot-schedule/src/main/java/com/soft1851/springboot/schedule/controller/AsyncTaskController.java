package com.soft1851.springboot.schedule.controller;

import com.soft1851.springboot.schedule.model.Cron;
import com.soft1851.springboot.schedule.model.User;
import com.soft1851.springboot.schedule.repository.CronRepository;
import com.soft1851.springboot.schedule.service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-16 17:08
 */
@RestController
@Slf4j
public class AsyncTaskController {
    @Resource
    private AsyncTaskService asyncTaskService;
    @Resource
    private CronRepository cronRepository;

    @RequestMapping("/asyncTask")
    public String asyncTask(){
        Future<Boolean> a = asyncTaskService.asyncTask();
        while (true){
            if (a.isDone()){
                break;
            }
            Cron cron = Cron.builder().cron("处理中").cronName("任务2").build();
            cronRepository.save(cron);
            System.out.println("正在处理，操作可能需要时间，您可以先去进行其他操作，完成后会通知");
        }
        Cron cron1 = cronRepository.findCronByCron("处理中");
        cronRepository.updateCron("处理完成",cron1.getCronId());
        return "测试完成";
    }
}
