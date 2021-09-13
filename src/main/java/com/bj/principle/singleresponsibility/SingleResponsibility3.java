package com.bj.principle.singleresponsibility;

public class SingleResponsibility3 {

    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.run("motor");
        vehicle2.runAir("flight");
        vehicle2.runWater("boat");

    }
}

//遵循了单一职责原则(没有在类级别上遵守 在方法上遵守)
//后续加功能只要加方法
class Vehicle2{
    public static void run(String vehicle){
        System.out.println(vehicle+" road run");
    }

    public static void runAir(String vehicle){
        System.out.println(vehicle+" air run");
    }

    public static void runWater(String vehicle){
        System.out.println(vehicle+" water run");
    }
}