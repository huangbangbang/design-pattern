package com.bj.springframework5Transaction;

import com.bj.springframework5Transaction.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:bean13.xml")*/
@SpringJUnitConfig(locations = "classpath:bean13.xml")
public class Test5 {
    @Autowired
    private AccountService accountService;

    @Test
    public void test1(){
        accountService.accountMoney();
    }


}
