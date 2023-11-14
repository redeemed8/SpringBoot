package com.jchhh.controller;

import com.jchhh.controller.utils.R;
import com.jchhh.dao.BookDao;
import com.jchhh.domain.Book;
import com.jchhh.service.BookService;
import com.jchhh.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @GetMapping("{telephone}")
    public String get(@PathVariable String telephone) {
        return msgService.get(telephone);
    }

    @PostMapping
    public boolean check(String telephone, String code) {
        return msgService.check(telephone, code);
    }

}
