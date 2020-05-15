package com.soft1851.springboot.schedule.controller;

import com.soft1851.springboot.schedule.model.Cron;
import com.soft1851.springboot.schedule.repository.CronRepository;
import com.soft1851.springboot.schedule.task.AutoTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-15 20:27
 */
@RestController
@Slf4j
@RequestMapping(value = "/api")
public class CronController {
    @Resource
    private CronRepository cronRepository;
    @Resource
    private AutoTask autoTask;
    @GetMapping("/updateCron")
    public String update(@RequestParam("cron") String cron, @RequestParam("id") int id){
        Cron cron1 = cronRepository.findCronByCronIdEquals(id);
        if (!cron.equals(cron1.getCron())){
            log.info("定时修改");
            Cron cron2 = Cron.builder().cronId(id).cron(cron).cronName(cron1.getCronName()).build();
            cronRepository.saveAndFlush(cron2);
            return "修改成功！";
        }else {
            return "新任务与原任务一致，修改失败";
        }
    }
}
