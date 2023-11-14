package com.jchhh.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jchhh.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        Book book = bookDao.selectById(3);
        System.out.println(book);
    }

    @Test
    void testSave() {
        Book book = new Book(null, "a", "xiyou", "这是西安邮电~");
        bookDao.insert(book);
        System.out.println("success");
    }

    @Test
    void testUpdate() {
        Book book = new Book(12, "b", "XiYou", "这是西安邮电2~");
        bookDao.updateById(book);
        System.out.println("success");
    }

    @Test
    void testDelete() {
        bookDao.deleteById(13);
    }

    @Test
    void testGetAll() {
        List<Book> list = bookDao.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page(1, 5);
        bookDao.selectPage(page, null);
    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "c");
        List<Book> books = bookDao.selectList(qw);
        books.forEach(System.out::println);
    }

    @Test
    void testGetBy2() {
        String name = "c";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        //  ↓  if(name != null)         lqw.like(Book::getName, name);
        lqw.like(name != null, Book::getName, name);
        List<Book> books = bookDao.selectList(lqw);
        books.forEach(System.out::println);
    }

}
