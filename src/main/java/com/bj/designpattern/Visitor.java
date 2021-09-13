package com.bj.designpattern;

import java.util.ArrayList;

public class Visitor {
    public static void main(String[] args) {
        Container container = new Container();
        container.add(new Man());
        container.add(new Man());
        container.add(new Man());
        container.add(new Women());
        Fail fail = new Fail();
        container.visitAll(fail);
        Wait wait = new Wait();
        container.visitAll(wait);
    }
}

abstract class Action {
    public abstract void getMan(Man man);

    public abstract void getWomen(Women man);
}

class Success extends Action {
    public void getMan(Man man) {
        System.out.println("男人成功");
    }

    @Override
    public void getWomen(Women man) {
        System.out.println("女人成功");
    }

}

class Fail extends Action {
    public void getMan(Man man) {
        System.out.println("男人失败");
    }

    @Override
    public void getWomen(Women man) {
        System.out.println("女人失败");
    }
}

class Wait extends Action {
    public void getMan(Man man) {
        System.out.println("男人等待");
    }

    @Override
    public void getWomen(Women man) {
        System.out.println("女人等待");
    }
}

abstract class Element {
    public abstract void accept(Action action);
}

class Man extends Element {
    @Override
    public void accept(Action action) {
        action.getMan(this);
    }
}

class Women extends Element {
    @Override
    public void accept(Action action) {
        action.getWomen(this);
    }
}

class Container {
    private ArrayList<Element> arrayList = new ArrayList();

    public void add(Element element) {
        arrayList.add(element);
    }

    public void remove(Element element) {
        arrayList.remove(element);
    }
    public void visitAll(Action action){
        for (Element e:arrayList){
            e.accept(action);
        }
    }
}

