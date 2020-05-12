package com.soft1851.springboot.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: Guorc
 * @Date: 2020/5/12 17:43
 * @Description:
 */
@SpringBootApplication
@Slf4j
public class SpringApplicationContextBootstrap {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        log.info(">>>>>>>>>>>>>>>>>>>>> ConfigurableApplicationContext 类型：" + context.getClass().getName());
        log.info(">>>>>>>>>>>>>>>>>>>>> Environment 类型：" + context.getEnvironment().getClass().getName());
        // 关闭上下文
        context.close();
    }
}
