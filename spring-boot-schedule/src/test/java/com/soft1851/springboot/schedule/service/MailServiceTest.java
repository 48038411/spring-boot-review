package com.soft1851.springboot.schedule.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MailServiceTest {
    @Resource
    private MailService mailService;
    @Test
    void sendSimpleTextMail() {
        String to = "477588184@qq.com";
        String subject = "springboot发送简单文本邮件";
        String content = "<h3>第一封springboot简单文本邮件</h3>";
        mailService.sendSimpleTextMail(to,subject,content);
    }

    @Test
    void sendHtmlMail() throws MessagingException {
        String to = "477588184@qq.com";
        String subject = "springboot发送HTML邮件";
        String content = "<h3>第一封springbootHTML邮件</h3>";
        mailService.sendHtmlMail(to,subject,content);
    }

    @Test
    void sendAttachmentMail() throws Exception{
        String to = "477588184@qq.com";
        String subject = "springboot发送附件邮件";
        String content = "<h3>第一封springboot附件邮件</h3>";
        String filePath = "pom.xml";
        mailService.sendAttachmentMail(to,subject,content,filePath);
    }

    @Test
    void sendImgMail() throws Exception{
        String to = "477588184@qq.com";
        String subject = "springboot发送图片邮件";
        String content = "<h2>第一封springboot图片邮件</h2>" +
                "<br/> <img src=\"cid:img01\" />";
        String imgPath = "birthday.png";
        Map<String,String> imgMap = new HashMap<>();
        imgMap.put("img01",imgPath);
        mailService.sendImgMail(to,subject,content,imgMap);
    }
}