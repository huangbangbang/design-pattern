package com.bj.springframework5Transaction;

import com.bj.springframework5JdbcTemplate.config.TxConfig;
import com.bj.springframework5Transaction.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TestSpring {


    @Test
    public void testJdbcTemplate(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean13.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();

    }
    @Test
    public void testJdbcTemplate1(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean14.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();

    }

    @Test
    public void testJdbcTemplate2(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(TxConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();

    }

    @Test
    public void testGenericApplicationContext(){
        GenericApplicationContext context = new GenericApplicationContext();
        context.refresh();
       /* context.registerBean(com.bj.springframework5Transaction.User.class,()->new com.bj.springframework5Transaction.User());
        com.bj.springframework5Transaction.User user = (com.bj.springframework5Transaction.User)
                context.getBean("com.bj.springframework5Transaction.User");*/
        context.registerBean("user1",com.bj.springframework5Transaction.User.class,()->new com.bj.springframework5Transaction.User());
        com.bj.springframework5Transaction.User user = (com.bj.springframework5Transaction.User)
                context.getBean("user1");
        System.out.println(user);

    }


}
