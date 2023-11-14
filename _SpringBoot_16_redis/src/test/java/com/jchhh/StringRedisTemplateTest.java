package com.jchhh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class StringRedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testGet(){
        ValueOperations<String, String> stringOps = stringRedisTemplate.opsForValue();
        String ret = stringOps.get("test");
        System.out.println(ret);
    }

}
