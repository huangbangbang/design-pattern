package com.bj.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Test28 {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        Map instance =(Map) new Proxy2(hashMap).getInstance();
        instance.put(1,123);
        instance.forEach((k,v)-> System.out.println(k+"=="+v));
    }
}

class Proxy2{
    private Object target;

    public Proxy2(Object target) {
        this.target = target;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("-------------------");
                        Object invoke = method.invoke(target, args);
                        System.out.println("-------------------");
                        return invoke;
                    }
                });
    }
}
