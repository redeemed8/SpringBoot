package com.jchhh.service.impl;

import com.jchhh.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//@Service
public class Pre_SendMailServiceImpl implements SendMailService {

//    @Autowired
//    private JavaMailSender javaMailSender;

    //  发送人
    private String fromPerson = "705794497@qq.com";

    //  接收人
    private String toPerson = "705794497@qq.com";

    //  标题
    private String subject = "测试邮件1标题";

    //  正文
    private String context = "这是邮件1正文";

    @Override
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromPerson + "(这里随意起名字)");
        message.setTo(toPerson);
        message.setSubject(subject);
        message.setText(context);
//        javaMailSender.send(message);
    }

}
