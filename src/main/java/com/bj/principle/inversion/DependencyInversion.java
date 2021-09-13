package com.bj.principle.inversion;

public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email{
    public String getInfo(){
        return "hello world";
    }
}

//获取的对象是微信 短信等 会新增类 person类会增加方法
//Email和WeChat都实现接口
class Person{
    public void receive(Email email){//person类依赖具体类Email 最好依赖抽象
        System.out.println(email.getInfo());
    }
}