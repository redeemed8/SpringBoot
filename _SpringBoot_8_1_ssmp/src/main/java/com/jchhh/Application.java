package com.jchhh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
//        args是命令行参数   ---也可以在从控制台添加
//        System.out.println(args);
        SpringApplication.run(Application.class, args);
    }

//  可以在启动 boot程序时 断开读取外部临时配置对应的入口，也就是去掉读取外部参数的形参
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class);
//    }

}
