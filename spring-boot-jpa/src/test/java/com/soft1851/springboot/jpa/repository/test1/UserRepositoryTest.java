package com.soft1851.springboot.jpa.repository.test1;

import com.soft1851.springboot.jpa.model.User;
import com.soft1851.springboot.jpa.repository.test2.UserTest2Repository;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTest2Repository userTest2Repository;
    @Test
    void testSave() {
        User user = User.builder()
                .userName("cyf")
                .password("123456")
                .nickName("cyf")
                .age(20)
                .regTime(LocalDateTime.now()).build();
        userRepository.save(user);
        userTest2Repository.save(user);

        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            User testUser = User.builder()
                    .userName("user" + i)
                    .password("psd" + i)
                    .nickName("nickName" + i)
                    .age(new Random().nextInt(25))
                    .regTime(LocalDateTime.now()).build();
            users.add(testUser);
        }
//        userRepository.saveAll(users);
        userTest2Repository.saveAll(users);
    }

    @Test
    void testSelectAll() {
        List<User> list1 = userRepository.findAll();
        System.out.println(list1.size());

        List<User> list2 = userTest2Repository.findAll();
        System.out.println(list2.size());
    }
}