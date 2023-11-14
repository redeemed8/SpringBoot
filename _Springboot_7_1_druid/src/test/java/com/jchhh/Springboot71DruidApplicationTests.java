package com.jchhh;

import com.jchhh.dao.BookDao;
import com.jchhh.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot71DruidApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        Book book = bookDao.getById(3);
        System.out.println(book);
    }

}
