package com.jchhh;

import com.jchhh.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot23MailApplicationTests {

    @Autowired
    private SendMailService service;

    @Test
    void contextLoads() {
        service.sendMail();
    }

}
