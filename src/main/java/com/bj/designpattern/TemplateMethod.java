package com.bj.designpattern;

public class TemplateMethod {
    public static void main(String[] args) {
        BlackBeanSoyMilk blackBeanSoyMilk = new BlackBeanSoyMilk();
        blackBeanSoyMilk.make();
        RedBeanSoyMilk redBeanSoyMilk = new RedBeanSoyMilk();
        redBeanSoyMilk.make();
    }
}

abstract class SoyMilk{
    protected void make(){
     prepare();
     chengJiang();
     add();
    }

    protected  void prepare(){
        System.out.println("准备好原料");
    }

    protected  void chengJiang(){
        System.out.println("碾磨成浆");
    }

    protected  void add(){}
}

class BlackBeanSoyMilk extends SoyMilk {
    @Override
    protected void add() {
        System.out.println("加黑豆");
    }
}

class RedBeanSoyMilk extends SoyMilk {
    @Override
    protected void add() {
        System.out.println("加红豆");
    }
}
