package com.bj.algorithm;

public class HanoiTower {
    public static void main(String[] args) {
        divideAndConquer(3,'A','B','C');
    }
    private static void divideAndConquer(int num ,char a,char b,char c){
        if (num==1){
            System.out.println("第1个盘子:"+a+"-->"+c);
        }else {
            divideAndConquer(num-1,a,c,b);
            System.out.println("第"+num+"个盘子:"+a+"-->"+c);
            divideAndConquer(num-1,b,a,c);

        }
    }
}
