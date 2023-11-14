package com.jchhh.service.impl;

import com.jchhh.dao.BookDao;
import com.jchhh.domain.Book;
import com.jchhh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }
}
