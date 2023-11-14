package com.jchhh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jchhh.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
    //  BaseMapper 大部分的功能都包括了
}
