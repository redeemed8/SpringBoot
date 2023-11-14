package com.jchhh.config;

import com.jchhh.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printJobDetail() {
        //  绑定具体的工作
        return JobBuilder
                .newJob(MyQuartz.class)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printJobTrigger() {
        //  绑定对应的工作明细                                                              s m h d 月 星期
        ScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //   * 代表任意             0/5 从零秒开始  每5秒执行一次
        return TriggerBuilder
                .newTrigger()
                .forJob(printJobDetail())
                .withSchedule(scheduleBuilder)
                .build();
    }

}
