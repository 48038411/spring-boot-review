package com.soft1851.springboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Author: Guorc
 * @Date: 2020/5/12 17:48
 * @Description: HelloWorld {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info(">>>>>>>>>>>>>>>> refresh applicationContext,Hello World: " + event.getApplicationContext().getId() +
                ", timestamp: " + event.getTimestamp());
    }
}