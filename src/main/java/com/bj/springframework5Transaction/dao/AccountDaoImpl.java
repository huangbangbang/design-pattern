package com.bj.springframework5Transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add() {
        String sql ="update account set money=money+? where name =?";
        jdbcTemplate.update(sql,100,"mary");
    }

    @Override
    public void reduce() {
        String sql ="update account set money=money-? where name =?";
        jdbcTemplate.update(sql,100,"lucy");
    }
}
