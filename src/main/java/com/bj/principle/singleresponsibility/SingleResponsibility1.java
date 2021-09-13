package com.bj.principle.singleresponsibility;

public class SingleResponsibility1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}

//违反了单一职责原则
class Vehicle{
    public static void run(String vehicle){
        System.out.println(vehicle+"  run");
    }
}
