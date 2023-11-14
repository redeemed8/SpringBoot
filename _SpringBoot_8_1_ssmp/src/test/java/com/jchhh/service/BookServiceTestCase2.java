package com.jchhh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jchhh.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase2 {

    @Autowired
    private IBookService bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(9));
    }

    @Test
    void testGetAll() {
        List<Book> list = bookService.list();
        list.forEach(System.out::println);
    }

    @Test
    void testUpdate() {
        Book book = new Book(7, "a", "Chinese", "语文2");
        try {
            bookService.updateById(book);
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDelete() {
        try {
            bookService.removeById(17);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSave() {
        Book book = new Book(null, "w", "----------", "最好的语言");
        try {
            bookService.save(book);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<>(2,5);
        bookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

}
