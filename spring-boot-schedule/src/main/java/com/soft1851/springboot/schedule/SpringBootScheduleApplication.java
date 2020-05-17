package com.soft1851.springboot.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Guorc
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringBootScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootScheduleApplication.class, args);
    }

}
