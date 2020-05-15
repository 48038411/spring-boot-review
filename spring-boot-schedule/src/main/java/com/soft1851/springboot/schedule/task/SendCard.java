package com.soft1851.springboot.schedule.task;

import com.soft1851.springboot.schedule.model.User;
import com.soft1851.springboot.schedule.repository.UserRepository;
import com.soft1851.springboot.schedule.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-15 16:03
 */
@Component
@Slf4j
public class SendCard {
    @Resource
    private UserRepository userRepository;
    @Resource
    private MailService mailService;

    /**
     * 每天凌晨一点执行一次任务
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void sendEmail() throws MessagingException {
        List<User> userList = userRepository.findUsersByBirthday();
        for (User user: userList
             ) {
            String to = user.getMail();
            String subject = user.getUsername()+"生日快乐";
            String content = "<h2>祝"+user.getUsername()+"生日快乐</h2>" +
                    "<br/> <img src=\"cid:img01\" />";
            String imgPath = "E:\\dev\\spring-boot-review (2)\\spring-boot-review\\spring-boot-schedule\\birthday.png";
            Map<String,String> birthday = new HashMap<>();
            birthday.put("img01",imgPath);
            mailService.sendImgMail(to,subject,content,birthday);
            log.info(user.getUsername()+"的祝福邮件发送成功");
        }
    }
}
