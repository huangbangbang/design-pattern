package com.bj.datastructure;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(4);

        char key = ' ';
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("s->show queue");
            System.out.println("h->get queue head");
            System.out.println("a->add");
            System.out.println("g->get");
            System.out.println("e->exit");
            key=scanner.next().charAt(0);

            switch (key){
                case 's':
                    arrayQueue.show();
                    break;
                case 'h':
                    try {
                        System.out.println(arrayQueue.getHead());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    arrayQueue.add(scanner.nextInt());
                    break;
                case 'g':
                    try {
                        System.out.println("出队"+arrayQueue.get());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop=false;
                    scanner.close();
                    break;
                default:
                    System.out.println("input error");
                    break;

            }
        }
        System.out.println("程序退出");
    }


}

class ArrayQueue{
    private int maxSize;
    private int front=0;
    private int rear=0;
    private int[] array;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[this.maxSize];
    }


    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public void add(int num){
        if (isFull()){
            System.out.println("queue is full");
            return;
        }
        array[rear]=num;
        System.out.println("入队:"+num);
        rear=(rear+1)%maxSize;
    }

    public int get(){
        if (isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        int value = array[front];
        front=(front+1)%maxSize;
        return value;
    }

    public int getHead(){
        if (isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return array[front];
    }

    public void show(){
        if (isEmpty()){
            System.out.println("queue is empty");
            return;
        }
        for (int i = front;i<front+size();i++){
            System.out.println(array[i]+" ");
        }
    }

    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
}
