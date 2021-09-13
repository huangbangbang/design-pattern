package com.bj.principle.singleresponsibility;

public class SingleResponsibility2 {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("motor");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("flight");

        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("boat");
    }
}

//遵循了单一职责原则
//将类分解 同时修改客户端
//比较臃肿
class RoadVehicle{
    public static void run(String vehicle){
        System.out.println(vehicle+" road  run");
    }
}

class AirVehicle{
    public static void run(String vehicle){
        System.out.println(vehicle+" air  run");
    }
}

class WaterVehicle{
    public static void run(String vehicle){
        System.out.println(vehicle+" water  run");
    }
}
