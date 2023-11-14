package com.jchhh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringBoot16RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testSet() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("test",55);
    }

    @Test
    void testGet() {
        ValueOperations ops = redisTemplate.opsForValue();
        Object age = ops.get("test");
        System.out.println(age);
    }

    @Test
    void testHset() {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("info","a","aaaaa");
    }

    @Test
    void testHget() {
        HashOperations ops = redisTemplate.opsForHash();
        Object ret = ops.get("info","a");
        System.out.println(ret);
    }

}
