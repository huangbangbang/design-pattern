package com.bj.datastructure;

public class CircleLinkedListDemo {
    public static void main(String[] args) {
        countBoy(2,3,5);
        /*CircleLinkedList circleLinkedList = new CircleLinkedList();*/
        /*circleLinkedList.add(5);*/
        /*circleLinkedList.list();*/
    }
    public static void countBoy(int k,int m, int n){
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.add(n);
        /*circleLinkedList.list();*/
        if (circleLinkedList.first==null||k<1||k>n){
            System.out.println("input error");
        }
        Boy helper=circleLinkedList.first;
        while (helper.next!=circleLinkedList.first){
            helper=helper.next;
        }
        for (int i=0;i<k-1;i++){
            circleLinkedList.first=circleLinkedList.first.next;
            helper=helper.next;
        }
        while (true){
            if (helper==circleLinkedList.first){
                break;
            }
            for (int j=0;j<m-1;j++){
                circleLinkedList.first=circleLinkedList.first.next;
                helper=helper.next;
            }
            System.out.println("出圈"+circleLinkedList.first);
            helper.next=circleLinkedList.first.next;
            circleLinkedList.first=helper.next;
        }
        System.out.println("最后出圈"+helper);
    }
}

class CircleLinkedList{
    public Boy first;
    public void add(int n){
        if (n<1){
            System.out.println("input error");
            return;
        }
        Boy temp=null;
        for (int i=1;i<=n;i++){
            Boy boy = new Boy(i);
            if (i==1){
                first=boy;
                first.next=first;
                temp=first;
            }else {
                temp.next=boy;
                boy.next=first;
                temp=boy;
            }
        }

    }
    public void list() {
        if (first == null) {
            System.out.println("empty");
            return;
        }
        Boy temp=first;
        do {
            System.out.println(temp);
            temp=temp.next;
        } while (temp!= first);
    }


}

class Boy{
    public int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "[" +
                "no=" + no +
                ']';
    }
}