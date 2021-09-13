package com.bj.springframework5JdbcTemplate.dao;

import com.bj.springframework5JdbcTemplate.entity.Book;

import java.util.List;

public interface BookDao {

    void add(Book book);

    void delete(int i);

    void update(Book book);

    Book get(int no);

    int findCount();

    List<Book> findAll();

    void addAll(List<Object[]> list);

    void UpdateAll(List<Object[]> list);

    void DeleteAll(List<Object[]> list);
}
