package com.bj.principle.ocp;

public class Test {


    public static void main(String[] args) {

        BPlusTree<Student, Integer> bPlusTree = new BPlusTree<>(4);

        long time1 = System.nanoTime();

        for (int i=0;i<1000;i++){
            Student student = new Student(i, "jack", i);
            bPlusTree.insert(student,student.getId());
        }

        long time2 = System.nanoTime();

        Student s1 = bPlusTree.find(222);

        long time3 = System.nanoTime();

        System.out.println("insert 1000 use time "+(time2-time1));
        System.out.println("search 222 use time "+(time3-time2));

        for (int i=0;i<500;i++){
            Student s = bPlusTree.find(i);
            System.out.println(s);
        }


    }
}
