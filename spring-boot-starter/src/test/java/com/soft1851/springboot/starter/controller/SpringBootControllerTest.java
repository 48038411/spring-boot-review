package com.soft1851.springboot.starter.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SpringBootControllerTest {
    @Autowired
    private SpringBootController springBootController;
    //HTTP请求的模拟对象，桩对象
    private MockMvc mockMvc;
    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(springBootController).build();
    }
    @Test
    void hello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
        .get("/api/hello")
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                .string("hello springboot"));
    }
}