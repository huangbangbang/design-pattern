package com.bj.springframework5Aop.aopAnnotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class PersonProxy {

    @Before(value = "execution(* com.bj.springframework5Aop.aopAnnotation.User.add(..))")
    public void before(){
        System.out.println("person before");
    }
}
