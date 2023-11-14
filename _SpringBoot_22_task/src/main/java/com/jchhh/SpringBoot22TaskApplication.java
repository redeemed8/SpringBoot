package com.jchhh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//  定时任务 开启的开关
@EnableScheduling
public class SpringBoot22TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot22TaskApplication.class, args);
    }

}
