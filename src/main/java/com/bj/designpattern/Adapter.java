package com.bj.designpattern;

public class Adapter {
    public static void main(String[] args) {
        /*Adapter1 adapter1 = new Adapter1();
        System.out.println(adapter1.outV5());*/

        /*Adapter2 adapter2 = new Adapter2(new V220());
        System.out.println(adapter2.outV5());*/

        Adapter3 adapter3 = new Adapter3(new V220());
        System.out.println(adapter3.outV5());
    }

}

interface V5{
    int outV5();
}

class V220{
    public int outV220(){
        return 220;
    }
}

class Adapter1 extends V220 implements V5 {

    @Override
    public int outV5() {
        int i = outV220();
        System.out.println("原本: "+i);
        int a = i/44;
        return a;
    }
}

class Adapter2 implements V5 {

    V220 v220;

    public Adapter2(V220 v220) {
        this.v220 = v220;
    }

    @Override
    public int outV5() {
        int i = v220.outV220();
        System.out.println("原本: "+i);
        int a = i/44;
        return a;
    }
}

interface V5MultipleMethod{
    int outV5();
    int another();
    int other();
}

class AbstractClass implements V5MultipleMethod {

    @Override
    public int outV5() {
        return 0;
    }

    @Override
    public int another() {
        return 0;
    }

    @Override
    public int other() {
        return 0;
    }
}

class Adapter3 extends AbstractClass {

    V220 v220;

    public Adapter3(V220 v220) {
        this.v220 = v220;
    }

    @Override
    public int outV5() {
        int i = v220.outV220();
        System.out.println("原本: "+i);
        int a = i/44;
        return a;
    }
}