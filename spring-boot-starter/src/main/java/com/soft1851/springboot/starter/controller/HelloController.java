package com.soft1851.springboot.starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-11 19:15
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring boot";
    }

    /**
     * 带路径参数请求
     * @param name
     * @return
     */
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(name = "name") String name){
        return "Hello" + name;
    }

    /**
     * 参数请求
     * @param name
     * @return
     */
    @GetMapping("/hello1")
    public String hello1(@RequestParam(name = "name") String name){
        return "Hello" + name;
    }
}
