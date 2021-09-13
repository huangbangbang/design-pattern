package com.bj.Test;

public class Test21 {
    public static void main(String[] args) {
        int ordinal = Season1.Spring.ordinal();
        int ordinal1 = Season1.Autumn.ordinal();
        System.out.println(Season1.Spring.name());
    }
}

enum Season1{
    Spring,Autumn;
}