package com.soft1851.springboot.starter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *标准的springboot接口
 * @author：Guorc
 * @create 2020-05-11 19:19
 */
@RestController
@RequestMapping("/api")
public class SpringBootController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot";
    }
}
