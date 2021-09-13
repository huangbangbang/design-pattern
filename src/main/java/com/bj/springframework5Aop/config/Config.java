package com.bj.springframework5Aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.bj.springframework5Aop"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {

}
