package com.bj.datastructure;

public class ArrayStackDemo {
    public static void main(String[] args) {



        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        Short  a =9;
        System.out.println(a);

        try {
            System.out.println(arrayStack.pop());
            System.out.println(arrayStack.peek());
            arrayStack.pop();
            arrayStack.pop();
            arrayStack.pop();
            arrayStack.pop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class ArrayStack{
    public int maxSize;
    public int top=-1;
    public int[] array;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array=new int[this.maxSize];
    }

    public boolean isFull(){
        return top==maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(int n){
        if (isFull()){
            System.out.println("stack is full");
            return;
        }
        top++;
        array[top]=n;
    }
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        int value = array[top];
        top--;
        return value;
    }
    public int peek(){
        if (isEmpty()){
            System.out.println("stack is empty");
        }
        return array[top];
    }
}



