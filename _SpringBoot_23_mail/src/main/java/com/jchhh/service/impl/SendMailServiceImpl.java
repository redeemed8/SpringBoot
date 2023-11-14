package com.jchhh.service.impl;

import com.jchhh.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    //  发送人
    private String fromPerson = "705794497@qq.com";

    //  接收人
    private String toPerson = "705794497@qq.com";

    //  标题
    private String subject = "测试邮件1标题";

    //  正文
    private String context = "<img src='https://img.tukuppt.com/png_preview/00/25/00/mV65FECTMt.jpg!/fw/780'/><a href='https://www.itcast.cn'>点开有惊喜</a>";

    @Override
    public void sendMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(fromPerson + "(二球)");
            helper.setTo(toPerson);
            helper.setSubject(subject);
            helper.setText(context, true);

            //  添加附件
            File f = new File("D:\\protjct\\1.png");

            helper.addAttachment("girl", f);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
