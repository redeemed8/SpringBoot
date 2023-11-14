package com.jchhh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jchhh.controller.utils.R;
import com.jchhh.domain.Book;
import com.jchhh.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
//        if(true)    throw  new IOException();
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        //  快捷键  Ctrl + F9      或者      构建 -> 构建项目
        System.out.println("test hot deploy!...");
        System.out.println("test hot deploy!...");
        System.out.println("test hot deploy!...");
        System.out.println("test hot deploy!...");
        System.out.println("test hot deploy!...");
        return new R(true, bookService.getById(id));
    }

//    @GetMapping("{currentPage}/{PageSize}")
//    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer PageSize) {
//        IPage<Book> page = bookService.getPage(currentPage, PageSize);
//        //  如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if (currentPage > page.getPages()) {
//            page = bookService.getPage((int) page.getPages(), PageSize);
//        }
//        return new R(true, page);
//    }

    @GetMapping("{currentPage}/{PageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer PageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, PageSize, book);
        //  如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), PageSize, book);
        }
        return new R(true, page);
    }
}
