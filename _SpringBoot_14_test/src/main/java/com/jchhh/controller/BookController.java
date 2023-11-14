package com.jchhh.controller;

import com.jchhh.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

//    @GetMapping
//    public String getById(){
//        System.out.println("getById  is  running....");
//        return "springboot1";
//    }

    @GetMapping
    public Book getById() {
        System.out.println("getById  is  running....");
        return new Book(1, "springboot", "a", "这是Springboot书");
    }

}
