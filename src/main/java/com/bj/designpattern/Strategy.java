package com.bj.designpattern;

import java.util.ArrayList;
import java.util.Comparator;

public class Strategy {
    public static void main(String[] args) {
        /*System.out.println("1-->9折");
        System.out.println("2-->7折");
        System.out.println("3-->5折");

        Scanner scanner = new Scanner(System.in);

        Goods goods = null;
        *//*switch (i){
            case 1: goods=new Goods(new Count1());break;
            case 2: goods=new Goods(new Count2());break;
            case 3: goods=new Goods(new Count3());break;
            default:
                System.out.println("error input");
        }*//*
        while (true) {
            System.out.println("please input ");
            int i = scanner.nextInt();
            if (i == 1) {
                goods = new Goods(new Count1());
                break;
            } else if (i == 2) {
                goods = new Goods(new Count2());
                break;
            } else if (i == 3) {
                goods = new Goods(new Count3());
                break;
            } else {
                System.out.println("error input");
            }
        }
        float sumPrice = 0;
        while (true) {
            System.out.println("please input price -1 to exit");
            float j = scanner.nextFloat();
            if (j == -1) break;
            System.out.println("please input count -1 to exit");
            float k = scanner.nextFloat();
            if (k == -1) break;
            sumPrice += j * k;
        }

        float price = goods.getPrice(sumPrice);
        System.out.println("totalPrice is: "+price+" rmb");*/

        ArrayList<Teacher> list = new ArrayList<>();
        list.add(new Teacher(1));
        list.add(new Teacher(7));
        list.add(new Teacher(3));
        list.add(new Teacher(2));

        /*Collections.sort(list, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                if (o1.getAge()==o2.getAge()){
                    return 0;
                }
                return o1.getAge()>o2.getAge()?-1:1;
            }
        });*/
        list.sort(new Comp1());

        list.forEach(s-> System.out.println(s));
    }

}

/*interface Count{
    float sum(float price);
}

class Count1 implements Count{
    @Override
    public float sum(float price) {
        return price*0.9f;
    }
}

class Count2 implements Count{
    @Override
    public float sum(float price) {
        return price*0.7f;
    }
}

class Count3 implements Count{
    @Override
    public float sum(float price) {
        return price*0.5f;
    }
}

class Goods{
    private Count count;

    public Goods(Count count) {
        this.count = count;
    }

    public float getPrice(float f){
        return count.sum(f);
    }
}*/

interface Comp{
    int com(Teacher teacher1, Teacher teacher2);
}

class Teacher{
    private int age;

    public Teacher(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Teacher[" +
                "age=" + age +
                ']';
    }
}

class Comp1 implements Comparator<Teacher>{

    @Override
    public int compare(Teacher o1, Teacher o2) {
        if (o1.getAge()==o2.getAge()){
            return 0;
        }
        return o1.getAge()>o2.getAge()?1:-1;
    }


}


