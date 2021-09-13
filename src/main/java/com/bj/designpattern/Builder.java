package com.bj.designpattern;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal1 = mealBuilder.order1();
        Meal meal2 = mealBuilder.order2();
        meal1.addItems(new ChickenBurger());
        meal1.showItems();
        System.out.println("产品总价格: "+meal1.getTotalPrice());
        meal2.showItems();
        System.out.println("产品总价格: "+meal2.getTotalPrice());
    }
}

interface Item{
    String getName();
    Packing packing();
    int getPrize();
}

abstract class Burger implements Item {
    @Override
    public Packing packing() {

        return new Wrapper();
    }

    @Override
    public abstract int getPrize();
}

abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {

        return new Bottle();
    }

    @Override
    public abstract int getPrize();
}

interface Packing{
    String getPacking();
}

class Wrapper implements Packing {

    @Override
    public String getPacking() {
        return "纸包装";
    }
}

class Bottle implements Packing {

    @Override
    public String getPacking() {
        return "瓶包装";
    }
}

class BeefBurger extends Burger {

    @Override
    public String getName() {
        return "牛肉汉堡";
    }

    @Override
    public int getPrize() {
        return 15;
    }
}

class ChickenBurger extends Burger {

    @Override
    public String getName() {
        return "鸡肉汉堡";
    }

    @Override
    public int getPrize() {
        return 10;
    }
}

class Cola extends ColdDrink {

    @Override
    public String getName() {
        return "可乐";
    }

    @Override
    public int getPrize() {
        return 3;
    }
}

class IceTea extends ColdDrink {

    @Override
    public String getName() {
        return "冰红茶";
    }

    @Override
    public int getPrize() {
        return 4;
    }
}

class Meal{
    private List<Item> itemList = new ArrayList<Item>();
    public void addItems(Item item){
        itemList.add(item);
    }
    public int getTotalPrice(){
        int totalPrice = 0;
        for (Item i:itemList
             ) {
            totalPrice+=i.getPrize();
        }
        return totalPrice;
    }
    public void showItems(){
        for (Item i:itemList
        ) {
            System.out.print("产品名字: "+i.getName());
            System.out.print(" 产品包装: "+i.packing().getPacking());
            System.out.println(" 产品价格: "+i.getPrize());
        }
    }
}

class MealBuilder{
    public Meal order1(){
        Meal meal = new Meal();
        meal.addItems(new BeefBurger());
        meal.addItems(new Cola());
        return meal;
    }

    public Meal order2(){
        Meal meal = new Meal();
        meal.addItems(new ChickenBurger());
        meal.addItems(new IceTea());
        return meal;
    }
}