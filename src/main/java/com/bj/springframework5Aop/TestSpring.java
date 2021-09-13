package com.bj.springframework5Aop;

import com.bj.springframework5Aop.aopAnnotation.User;
import com.bj.springframework5Aop.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {


    @Test
    public void test1(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean11.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void test2(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean12.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }

}
