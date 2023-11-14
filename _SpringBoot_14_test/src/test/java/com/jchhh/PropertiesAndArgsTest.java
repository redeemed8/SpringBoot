package com.jchhh;

import com.jchhh.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

//  properties可以为当前测试类添加临时属性配置
//@SpringBootTest(properties = {"test.prop=testValue1"})
//  args添加临时的命令行参数
//@SpringBootTest(args = {"--test.prop=testValue2"})
//  args高于 properties
@SpringBootTest(args = {"--test.prop=testValue2"}, properties = {"test.prop=testValue1"})
public class PropertiesAndArgsTest {

    @Value("${test.prop}")
    private String msg;

    @Autowired
    private BookCase bookCase;

    @Test
    void testProperties() {
        System.out.println(msg);
        System.out.println(bookCase);
    }

}
