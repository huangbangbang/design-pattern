package com.bj.springframework5Aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Proxy {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        List proxyFactory =(List) new ProxyFactory(integers).getProxyInstance();
        proxyFactory.add(1);
        proxyFactory.add(2);
        proxyFactory.add(3);
        proxyFactory.add(4);
        proxyFactory.forEach(s-> System.out.println(s));
    }
}

class ProxyFactory{
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return java.lang.reflect.Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before");
                        Object res = method.invoke(target, args);
                        System.out.println("after");
                        return res;
                    }
                });
    }
}
