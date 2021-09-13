package com.bj.designpattern;

public class Decorator {
    public static void main(String[] args) {
        Drink drink = new Latte();
        System.out.println(drink.getPrice());
        drink = new Milk(drink);
        drink = new Milk(drink);
        drink = new Milk(drink);
        drink = new Chocolate(drink);
        drink = new Soy(drink);
        drink = new Soy(drink);
        System.out.println(drink.getPrice());
    }
}

abstract class Drink{
    int getPrice() {
        return 0;
    }
}

class Coffee extends Drink {
    int getPrice() {
        return 0;
    }
}

class Latte extends Coffee {
    private int price;
    public Latte() {
        this.price = 10;
    }

    public int getPrice() {
        return price;
    }
}

class Cappuccino extends Coffee {
    private int price;
    public Cappuccino() {
        this.price = 150;
    }

    public int getPrice() {
        return price;
    }
}

class Mocha extends Coffee {
    private int price;
    public Mocha() {
        this.price = 20;
    }

    public int getPrice() {
        return price;
    }
}

class DrinkDecorator extends Drink {
    public Drink drink;
}

class Milk extends DrinkDecorator {
    private int price;

    public Milk(Drink drink) {
        this.drink = drink;
        this.price = 2;
    }
    public int getPrice() {
        return drink.getPrice()+price;
    }
}

class Soy extends DrinkDecorator {
    private int price;

    public Soy(Drink drink) {
        this.drink = drink;
        this.price = 1;
    }
    public int getPrice() {
        return drink.getPrice()+price;
    }
}

class Chocolate extends DrinkDecorator {
    private int price;

    public Chocolate(Drink drink) {
        this.drink = drink;
        this.price = 3;
    }

    public int getPrice() {
        return drink.getPrice()+price;
    }
}