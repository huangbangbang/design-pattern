package com.bj.datastructure;

import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Friend2 friend21 = new Friend2(1, "jack");
        Friend2 friend22 = new Friend2(2, "jack");
        Friend2 friend23 = new Friend2(3, "jack");
        Friend2 friend24 = new Friend2(4, "jack");
        Friend2 friend25 = new Friend2(5, "jack");
        SingleLinkedList3 singleLinkedList3 = new SingleLinkedList3();
        singleLinkedList3.add(friend21);
        singleLinkedList3.add(friend22);
        singleLinkedList3.add(friend23);
        singleLinkedList3.add(friend24);
        singleLinkedList3.add(friend25);
        singleLinkedList3.show();
        /*singleLinkedList3.reverseLinkedList();
        System.out.println("反转后链表.................................");
        singleLinkedList3.show();*/
        System.out.println("从尾到头打印链表");
        singleLinkedList3.printTailToFront();

    }

}

class SingleLinkedList3{
    private Friend2 head =new Friend2(0," ");

    public Friend2 getHead() {
        return head;
    }

    public void add(Friend2 friend){
        Friend2 temp = head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=friend;
    }
    public void show(){
        Friend2 temp = head.next;
        if (temp==null){
            System.out.println("empty");
            return;
        }
        while (temp!= null) {
            System.out.println(temp);
            temp=temp.next;
        }
    }
    public void reverseLinkedList(){
        Friend2 temp = head.next;
        Friend2 newHead = new Friend2(-1," ");
        Friend2 cur=temp;
        if (head.next==null){
            System.out.println("empty");
            return;
        }
        while (temp!=null){
            cur=temp.next;
            temp.next=newHead.next;
            newHead.next=temp;
            temp=cur;
        }
        head.next=newHead.next;
    }
    public void printTailToFront(){
        if (head.next==null){
            System.out.println("empty linkedList");
            return;
        }
        Stack stack = new Stack();
        Friend2 temp = head.next;
        while (temp!=null){
            stack.add(temp);
            temp=temp.next;
        }
        /*System.out.println(stack.size());
        System.out.println(stack.capacity());*/
        int a = stack.size();//stack的size会动态变化
        for (int i=0;i<a;i++){
            System.out.println(stack.pop());
        }

    }
}

class Friend2{
    public int no;
    public String name;
    public Friend2 next;

    public Friend2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ']';
    }
}