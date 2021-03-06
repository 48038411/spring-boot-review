package com.soft1851.springboot.schedule.repository;


import com.soft1851.springboot.schedule.model.User;
import org.assertj.core.api.LocalDateAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.Formatter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void add(){
        User user = User.builder().username("48038411").password("123456").birthday(LocalDateTime.now()).build();
        userRepository.save(user);
    }
    @Test
    void find(){
        List<User> users = userRepository.findUsersByBirthday();
        users.forEach(user -> System.out.println("今天生日的用户有："+user.getUsername()));
    }
}