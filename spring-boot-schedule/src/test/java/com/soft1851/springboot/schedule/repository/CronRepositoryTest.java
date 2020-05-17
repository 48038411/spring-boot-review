package com.soft1851.springboot.schedule.repository;

import com.soft1851.springboot.schedule.model.Cron;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CronRepositoryTest {
    @Resource
    private CronRepository cronRepository;
    @Test
    void findCronByCronIdEquals() {
        Cron cron1 = cronRepository.findCronByCronIdEquals(1);
        Cron cron2 = Cron.builder().cronId(1).cron("0/10 * * * * ?").cronName(cron1.getCronName()).build();
        cronRepository.saveAndFlush(cron2);
        System.out.println("修改成功");
    }
    @Test
    void find(){
        Cron cron = cronRepository.findCronByCron("处理完成");
        System.out.println(cron.getCronName());
    }
}