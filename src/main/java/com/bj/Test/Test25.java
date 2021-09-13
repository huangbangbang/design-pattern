package com.bj.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test25 implements Runnable{

    public Test25(String name) {
        this.name = name;
    }


    @Deprecated
    public static int no;
    public  String name;
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.bj.Test.Test25");
        /*Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f:declaredFields
             ) {
            System.out.println(f.getName());
        }
        Field name = aClass.getDeclaredField("name");
        System.out.println(name.getType());*/

        /*Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor c:constructors
             ) {
            System.out.println(c.getParameterCount());
        }*/
        /*Method[] methods = aClass.getDeclaredMethods();
        for (Method m:methods
             ) {
            System.out.println(m.getName());
        }*/
        Class<?>[] classes = aClass.getClasses();

        for (Class c:classes){
            System.out.println(c.getSimpleName());
        }
    }

    @Override
    public void run() {

    }

    public static class Test251{
        private int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }
    public  class Test252{
        private int b;

        public Test252(int b) {
            this.b = b;
        }
    }

    public void method1(){
        class Test253{
            int c;

            public int getC() {
                return c;
            }

            public void setC(int c) {
                this.c = c;
            }
        }
    }
    public List method2(){
        return new List() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public Object set(int index, Object element) {
                return null;
            }

            @Override
            public void add(int index, Object element) {

            }

            @Override
            public Object remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator listIterator() {
                return null;
            }

            @Override
            public ListIterator listIterator(int index) {
                return null;
            }

            @Override
            public List subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }
}
