package com.bj.springframework5Ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//可替代xml文件
@Configuration
@ComponentScan(basePackages = {"com.bj.springframework5Ioc"})
public class SpringConfig {

}
