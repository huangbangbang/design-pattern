package com.bj.datastructure;

public class Queen8 {

    int num = 8;
    int[] array = new int[num];

    static int count;
    static int judgeCount;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);
        System.out.println(judgeCount);
    }


    private void check(int n) {
        if (n == num) {
            print();
            return;
        }
        for (int i = 0; i < num; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(array[i] - array[n]) == Math.abs(i - n)) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
