package com.jchhh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
    public R update(@RequestBody Book book) {
        return new R(bookService.update(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

}
