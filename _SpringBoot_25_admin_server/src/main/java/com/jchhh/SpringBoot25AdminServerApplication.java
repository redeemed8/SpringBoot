package com.jchhh;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringBoot25AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot25AdminServerApplication.class, args);
    }

}
