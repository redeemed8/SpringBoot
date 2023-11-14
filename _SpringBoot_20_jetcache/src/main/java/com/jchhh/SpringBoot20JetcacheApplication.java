package com.jchhh;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//  jetcache 启用缓存的主开关
@EnableCreateCacheAnnotation
//  开启方法注解缓存
@EnableMethodCache(basePackages = "com.jchhh")
public class SpringBoot20JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot20JetcacheApplication.class, args);
    }

}
