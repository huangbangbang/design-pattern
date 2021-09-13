package com.bj.designpattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Proxy {
    public static void main(String[] args) {
        /*Target target = new Target();
        ProxyTarget proxyTarget = new ProxyTarget(target);
        proxyTarget.method();*/

        /*Target target = new Target();
        H proxyFactory = (H) new ProxyFactory(target).getProxyInstance();
        proxyFactory.method();
        System.out.println(proxyFactory.getClass());*/

        /*ArrayList<Object> list = new ArrayList<>();
        List proxyFactory =(List) new ProxyFactory(list).getProxyInstance();
        proxyFactory.add(1);
        proxyFactory.add(2);
        proxyFactory.add(3);
        proxyFactory.add(4);
        proxyFactory.add(5);
        proxyFactory.forEach(s-> System.out.println(s));
        System.out.println(proxyFactory.getClass());
        System.out.println(java.lang.reflect.Proxy.isProxyClass(proxyFactory.getClass()));
        System.out.println(java.lang.reflect.Proxy.getInvocationHandler(proxyFactory));*/


        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ArrayList.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("--------------------------");
                Object o1 = methodProxy.invokeSuper(o, objects);
                System.out.println("----------------------------");
                return o1;
            }
        });

        ArrayList arrayList =(ArrayList) enhancer.create();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        arrayList.forEach(a-> System.out.println(a));

    }
}

interface H {
    public void method();
}

class Target implements H {
    public void method() {
        System.out.println("target method");
    }
}

class ProxyTarget implements H {
    private H h;

    public ProxyTarget(H h) {
        this.h = h;
    }

    public void method() {
        System.out.println("------------------");
        h.method();
        System.out.println("------------------");
    }
}

class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return java.lang.reflect.Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object ret = method.invoke(target, args);
                        return ret;
                    }
                });
    }

}