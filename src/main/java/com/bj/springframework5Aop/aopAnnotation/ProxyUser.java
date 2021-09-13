package com.bj.springframework5Aop.aopAnnotation;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ProxyUser {

    @Pointcut(value = "execution(* com.bj.springframework5Aop.aopAnnotation.User.add(..))")
    public void point(){

    }
    @Before(value = "point()")
    public void before(){
        System.out.println("before method");
    }

    @After(value = "execution(* com.bj.springframework5Aop.aopAnnotation.User.add(..))")
    public void After(){
        System.out.println("After method");
    }

    @AfterReturning(value = "execution(* com.bj.springframework5Aop.aopAnnotation.User.add(..))")
    public void AfterReturning(){
        System.out.println("AfterReturning method");
    }

    @AfterThrowing(value = "execution(* com.bj.springframework5Aop.aopAnnotation.User.add(..))")
    public void AfterThrowing(){
        System.out.println("AfterThrowing method");
    }

    @Around(value = "execution(* com.bj.springframework5Aop.aopAnnotation.User.add(..))")
    public void Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around method before");
        proceedingJoinPoint.proceed();
        System.out.println("Around method after");
    }
}
