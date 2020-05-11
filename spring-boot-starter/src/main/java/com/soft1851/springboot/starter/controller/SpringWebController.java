package com.soft1851.springboot.starter.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *标准滴spring MVC控制器
 * @author：Guorc
 * @create 2020-05-11 19:23
 */
@RestController
@RequestMapping("/springweb")
@ResponseBody
public class SpringWebController {
    @RequestMapping("/hello")
    public String hello() {
        return "<h2>Hello, Spring Boot!<h2>";
    }

}
