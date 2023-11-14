package com.jchhh.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Scheduled(cron = "0/2 * * * * ?")
    public void print() {
        System.out.println(Thread.currentThread().getName() + ": spring task run...");
    }

}
