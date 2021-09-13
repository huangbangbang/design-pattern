package com.bj.springframework5Transaction.service;

import com.bj.springframework5Transaction.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    //类或方法上

    public void accountMoney(){

            accountDao.reduce();
            accountDao.add();

    }


}
