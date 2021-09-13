package com.bj.springframework5JdbcTemplate;

import com.bj.springframework5JdbcTemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestSpring {


    @Test
    public void testJdbcTemplate(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean13.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        //Book book = new Book(4,"c++",100);
        /*int i = bookService.selectCount();
        System.out.println(i);*/
        /*Book book = bookService.get(1);
        System.out.println(book);*/

        /*System.out.println(bookService.list());*/
        /*Object[] o1 = {6,"java",29};
        Object[] o2 = {7,"java",29};
        Object[] o3 = {8,"java",29};
        List<Object[]> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);
        list.add(o3);
        bookService.batchAdd(list);*/

        /*Object[] o1 = {"java",20,6};
        Object[] o2 = {"c",20,7};
        Object[] o3 = {"python",20,8};
        List<Object[]> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);
        list.add(o3);
        bookService.batchUpdate(list);*/

        Object[] o1 = {2};
        Object[] o2 = {7};
        List<Object[]> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);
        bookService.batchDelete(list);
    }


}
