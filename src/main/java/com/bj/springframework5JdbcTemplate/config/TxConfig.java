package com.bj.springframework5JdbcTemplate.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

//@Configuration
//@ComponentScan(basePackages = "com.bj")
//@EnableTransactionManagement
public class TxConfig {

    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql:///user_db?characterEncoding=utf-8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DruidDataSource druidDataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource druidDataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(druidDataSource);
        return dataSourceTransactionManager;
    }
}
