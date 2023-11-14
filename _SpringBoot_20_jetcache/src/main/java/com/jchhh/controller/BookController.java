package com.jchhh.controller;

import com.alicp.jetcache.anno.*;
import com.jchhh.controller.utils.R;
import com.jchhh.domain.Book;
import com.jchhh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("{id}")
//    @Cached(name = "book", key = "#id", expire = 3600,cacheType = CacheType.LOCAL)
    @Cached(name = "book_", key = "#id", expire = 3600)      //  默认会使用 Redis
//    @CacheRefresh(refresh = 10)         //  单位是秒
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    @GetMapping
    public R getAll() {
        return new R(true, bookService.getAll());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
//        if(true)    throw  new IOException();
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    public R update(@RequestBody Book book) {
        return new R(bookService.update(book));
    }

    @DeleteMapping("{id}")
    @CacheInvalidate(name = "book_", key = "#id")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

}
