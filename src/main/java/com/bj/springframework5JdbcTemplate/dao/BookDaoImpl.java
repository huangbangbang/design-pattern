package com.bj.springframework5JdbcTemplate.dao;


import com.bj.springframework5JdbcTemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Book book) {
        //sql语句
        //sql语句值
        String sql = "insert into book values(?,?,?)";
        Object[] args = {book.getNo(), book.getName(), book.getAge()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from book where no = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    @Override
    public void update(Book book) {
        String sql = "update book set name=?, age=? where no=?";
        Object[] args = { book.getName(), book.getAge(),book.getNo()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public Book get(int no) {
        String sql = "select * from book where no=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), no);
        return book;
    }

    @Override
    public int findCount() {
        String sql = "select count(*) from book";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;
    }

    @Override
    public List<Book> findAll() {
        String sql = "select * from book";
        List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return list;
    }

    @Override
    public void addAll(List<Object[]> list) {
        String sql = "insert into book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void UpdateAll(List<Object[]> list) {
        String sql = "update book set name=?, age=? where no=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void DeleteAll(List<Object[]> list) {
        String sql = "delete from book where no = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }
}
