package com.jchhh;

import com.jchhh.domain.Book;
import com.jchhh.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class DaoTest {

    @Autowired
    private BookService bookService;

    @Test
    void testSave(){
        Book book = new Book(null, "springboot", "a", "这是Springboot书");
        bookService.save(book);
    }
}
