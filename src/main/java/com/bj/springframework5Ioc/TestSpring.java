package com.bj.springframework5Ioc;

import com.bj.springframework5Ioc.bean.Emp;
import com.bj.springframework5Ioc.bean.Orders;
import com.bj.springframework5Ioc.config.SpringConfig;
import com.bj.springframework5Ioc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {


    @Test
    public void test1(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        User user =context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void test2(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void test3(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    @Test
    public void test4(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean4.xml");
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);
    }


    @Test
    public void test5(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean5.xml");
        Book book = context.getBean("book", Book.class);
        Book book1 = context.getBean("book", Book.class);
        System.out.println(book.hashCode());
        System.out.println(book1.hashCode());
    }

    @Test
    public void test6(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean6.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void test7(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean7.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("forth use");
        System.out.println(orders);
        context.close();
    }

    @Test
    public void test8(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean8.xml");
        com.bj.springframework5Ioc.AutoWire.Emp emp = context.getBean("emp", com.bj.springframework5Ioc.AutoWire.Emp.class);
        System.out.println(emp);
    }

    @Test
    public void test10(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean10.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
        student.add();
    }

    @Test
    public void test11(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void test12(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
