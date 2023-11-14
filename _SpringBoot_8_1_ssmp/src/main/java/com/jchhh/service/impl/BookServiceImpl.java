package com.jchhh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jchhh.dao.BookDao;
import com.jchhh.domain.Book;
import com.jchhh.service.IBookService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    private Counter counter;

    public BookServiceImpl(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("用户付费操作次数:");       // 冒号后不能有空格
    }

    @Override
    public boolean saveBook(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean modify(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        //  每次执行删除业务，我们就把它看作成执行了付费业务
        counter.increment();
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer PageSize) {
        IPage<Book> page = new Page<>(currentPage, PageSize);
        bookDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer PageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        IPage<Book> page = new Page<>(currentPage, PageSize);
        bookDao.selectPage(page, lqw);
        return page;
    }
}
