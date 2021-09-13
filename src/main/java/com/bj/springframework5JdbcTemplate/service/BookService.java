package com.bj.springframework5JdbcTemplate.service;


import com.bj.springframework5JdbcTemplate.dao.BookDao;
import com.bj.springframework5JdbcTemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book) {
        bookDao.add(book);
    }

    public void updateBook(Book book) {
        bookDao.update(book);
    }

    public void deleteBook(int i) {
        bookDao.delete(i);
    }

    public Book get(int no){
        return bookDao.get(no);
    }

    public int selectCount(){
       return bookDao.findCount();
    }

    public List<Book> list(){
       return bookDao.findAll();
    }

    public void batchAdd(List<Object[]> list){
        bookDao.addAll(list);
    }

    public void batchUpdate(List<Object[]> list){
        bookDao.UpdateAll(list);
    }

    public void batchDelete(List<Object[]> list){
        bookDao.DeleteAll(list);
    }
}
