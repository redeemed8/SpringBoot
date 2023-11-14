package com.jchhh.dao;

import com.jchhh.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {

    @Select("select * from springboot_db.tb_book where id = #{id}")
    public Book getById(Integer id);

}
