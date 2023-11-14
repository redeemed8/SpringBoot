//package com.jchhh;
//
//import com.jchhh.domain.Book;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.ResultSetExtractor;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Map;
//
//@SpringBootTest
//class SpringBoot15SqlApplicationTests {
//
//    @Test
//    void contextLoads() {
//
//    }
//
//    @Test
//    void testJDBCTemplate(@Autowired JdbcTemplate jdbcTemplate) {
//
//        String sql = "select * from tb_book where id in (1,2,3)";
//
////        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
////        maps.forEach(System.out::println);
//
//        RowMapper<Book> rm = new RowMapper<Book>() {
//            @Override
//            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Book temp = new Book();
//                temp.setId(rs.getInt("id"));
//                temp.setName(rs.getString("name"));
//                temp.setType(rs.getString("type"));
//                temp.setDescription(rs.getString("description"));
//                return temp;
//            }
//        };
//        List<Book> list = jdbcTemplate.query(sql, rm);
//        list.forEach(System.out::println);
//
//    }
//
//    @Test
//    void testSave(@Autowired JdbcTemplate jdbcTemplate) {
//
//        String sql = "insert into tb_book values(null,'a','java2','JAVA速成下')";
//        int rows = jdbcTemplate.update(sql);
//        System.out.println(rows);
//
//    }
//
//
//}
