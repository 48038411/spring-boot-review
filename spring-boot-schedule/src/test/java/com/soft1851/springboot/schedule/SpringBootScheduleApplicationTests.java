package com.soft1851.springboot.schedule;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootScheduleApplicationTests {
    @Autowired
    private StringEncryptor stringEncryptor;
    @Test
    void contextLoads() {
        //加密密码
        String password = stringEncryptor.encrypt("root");
        System.out.println(password);
        //解密
        System.out.println(stringEncryptor.decrypt(password));

        String emailPwd = stringEncryptor.encrypt("xntdjafcxeihbidj");
        System.out.println(emailPwd);
        System.out.println(stringEncryptor.decrypt(emailPwd));
    }

}
