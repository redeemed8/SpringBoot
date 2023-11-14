package com.jchhh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jchhh.domain.Book;
import com.jchhh.service.IBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {

    //@Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return bookService.modify(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping("{currentPage}/{PageSize}")
    public IPage<Book> getPage(@PathVariable Integer currentPage, @PathVariable Integer PageSize) {
        return bookService.getPage(currentPage, PageSize);
    }
}
