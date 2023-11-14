package com.jchhh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jchhh.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
