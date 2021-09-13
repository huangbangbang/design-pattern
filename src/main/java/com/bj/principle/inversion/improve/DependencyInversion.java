package com.bj.principle.inversion.improve;
//依赖倒转原则
public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeChat());
    }

}

interface Receive{
    String getInfo();


}

class Email implements Receive {
    public String getInfo(){
        return "email hello world";
    }
}

class WeChat implements Receive {
    public String getInfo(){
        return "weChat hello world";
    }
}

class Person {
    public void receive(Receive receive) {//person类依赖抽象
        System.out.println(receive.getInfo());
    }
}