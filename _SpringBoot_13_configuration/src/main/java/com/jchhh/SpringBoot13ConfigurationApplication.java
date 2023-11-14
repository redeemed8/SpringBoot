package com.jchhh;

import com.alibaba.druid.pool.DruidDataSource;
import com.jchhh.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBoot13ConfigurationApplication {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBoot13ConfigurationApplication.class, args);
        ServerConfig bean = ctx.getBean(ServerConfig.class);
        System.out.println(bean);

        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
        System.out.println(ds.getDriverClassName());
        System.out.println(ds.getPassword());

    }

}



