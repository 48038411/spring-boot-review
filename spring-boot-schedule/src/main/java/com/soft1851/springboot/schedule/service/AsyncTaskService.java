package com.soft1851.springboot.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author Guorc
 */
@Service
@Slf4j
public class AsyncTaskService {
    @Async
    public Future<Boolean> asyncTask(){
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("处理数据中");
        return new AsyncResult<>(true);
    }
}
