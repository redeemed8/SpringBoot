package com.jchhh.dao.impl;

import com.jchhh.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("bookDao is running....");
    }
}
