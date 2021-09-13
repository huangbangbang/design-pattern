package com.bj.designpattern;

public class Factory {
    public static void main(String[] args) {
        /*Factory1 factory1 = new Factory1();
        Phone iphone = factory1.getIphone();
        Phone huaWei = factory1.getHuaWei();*/

        /*AbstractFactory chinaFactory = new ChinaFactory();
        AbstractFactory englandFactory = new EnglandFactory();
        chinaFactory.getHuaWei();
        chinaFactory.getIphone();
        System.out.println("=========================================");
        englandFactory.getIphone();
        englandFactory.getHuaWei();*/

        AbstractFactory1 chinaFactory1 = new ChinaFactory1();
        AbstractFactory1 englandFactory1 = new EnglandFactory1();
        chinaFactory1.getTesla();
        chinaFactory1.getBenz();
        englandFactory1.getBenz();

    }
}

class Factory1 {
    public Phone getIphone() {
        return new Iphone();
    }
    public Phone getHuaWei() {
        return new HuaWei();
    }
}

interface Phone{

}

class Iphone implements Phone {
    public Iphone() {
        this.make();
    }

    private void make() {
        System.out.println("Phone is made");
    }
}

class HuaWei implements Phone {
    public HuaWei() {
        this.make();
    }

    private void make() {
        System.out.println("HuaWei is made");
    }
}

interface AbstractFactory{
    Phone getIphone();
    Phone getHuaWei();
}

class ChinaFactory implements AbstractFactory {
    public Phone getIphone() {
        return new Iphone();
    }
    public Phone getHuaWei() {
        return new HuaWei();
    }
}

class EnglandFactory implements AbstractFactory {
    public Phone getIphone() {
        return new Iphone();
    }

    @Override
    public Phone getHuaWei() {
        System.out.println("因为制裁，我生产不了华为手机");
        throw new UnsupportedOperationException();
    }
}

interface AbstractFactory1{
    Phone getIphone();
    Phone getHuaWei();
    Car getBenz();
    Car getTesla();
}

class ChinaFactory1 implements AbstractFactory1 {
    public Phone getIphone() {
        return new Iphone();
    }
    public Phone getHuaWei() {
        return new HuaWei();
    }

    @Override
    public Car getBenz() {
        System.out.print("China ");
        return new Benz();
    }

    @Override
    public Car getTesla() {
        System.out.print("China ");
        return new Tesla();
    }
}

class EnglandFactory1 implements AbstractFactory1 {
    public Phone getIphone() {
        return new Iphone();
    }

    @Override
    public Phone getHuaWei() {
        System.out.println("因为制裁，我生产不了华为手机");
        throw new UnsupportedOperationException();
    }

    @Override
    public Car getBenz() {
        System.out.print("England ");
        return new Benz();
    }

    @Override
    public Car getTesla() {
        System.out.print("England ");
        return new Tesla();
    }
}

interface Car{

}

class Benz implements Car {
    public Benz() {
        this.make();
    }

    private void make() {
        System.out.println("benz is made");
    }
}

class Tesla implements Car {
    public Tesla() {
        this.make();
    }

    private void make() {
        System.out.println("tesla is made");
    }
}