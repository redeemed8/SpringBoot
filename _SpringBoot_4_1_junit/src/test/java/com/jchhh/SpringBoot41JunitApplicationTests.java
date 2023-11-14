package com.jchhh;

import com.jchhh.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//  当引导类(也叫配置类)找不到时使用后 classes
@SpringBootTest(classes = SpringBoot41JunitApplication.class)
class SpringBoot41JunitApplicationTests {
    //  1. 注入你要测试的对象
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        //  2. 执行要测试的对象对应的方法
        bookDao.save();
    }

}
