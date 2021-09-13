package com.bj.springframework5Transaction;


import com.bj.springframework5Transaction.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean13.xml")
public class test {
    @Autowired
    private AccountService accountService;

    @Test
    public void test1(){
        accountService.accountMoney();
    }
}
