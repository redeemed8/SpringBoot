package com.jchhh;

import com.jchhh.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class SpringBoot17MongoDbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        Book book = new Book(1, "a", "springboot", "速成");
        mongoTemplate.save(book);
    }

    @Test
    void find() {
        List<Book> all = mongoTemplate.findAll(Book.class);

        all.forEach(System.out::println);
    }

}
