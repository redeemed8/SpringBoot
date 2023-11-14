package com.jchhh;

import com.jchhh.dao.BookDao;
import com.jchhh.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot61MybatisPlusApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        //  如果有失败就是它把数据库的名字也用驼峰映射了，然后就找不到数据库
        Book book = bookDao.selectById(2);
        System.out.println(book);
    }

    @Test
    void testGetAll() {
        List<Book> list = bookDao.selectList(null);
        list.forEach(System.out::println);
    }

}
