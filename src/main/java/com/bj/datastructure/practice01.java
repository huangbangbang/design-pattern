package com.bj.datastructure;

public class practice01 {
    public static void main(String[] args) {

        Friend friend1 = new Friend(1, "jack");
        Friend friend2 = new Friend(2, "tom");
        Friend friend3 = new Friend(3, "mary");
        Friend friend4 = new Friend(4, "bob");
        SingleLinkedList2 singleLinkedList2 = new SingleLinkedList2();
        singleLinkedList2.add(friend1);
        singleLinkedList2.add(friend2);
        singleLinkedList2.add(friend3);
        singleLinkedList2.add(friend4);
        try {
            singleLinkedList2.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int b = 0;
        try {
            b = singleLinkedList2.count();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("链表有效节点个数:"+b);
        Friend res =null;
        try {
            res=singleLinkedList2.findByLastIndex(9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(res);
    }
}

class SingleLinkedList2{
    private Friend head=new Friend(0," ");

    public void add(Friend friend){
        Friend temp = head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=friend;
    }
    public void show(){
        Friend temp = head.next;
        if (temp==null){
            System.out.println("链表为空");
            return;
        }
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
    public int count(){
        if (head.next==null){
            throw new RuntimeException("链表为空");
        }
        Friend temp = head.next;
        int count = 0;
        while (true){
            if (temp==null){
                break;
            }
            count++;
            temp=temp.next;
        }
        return count;
    }
    public Friend findByLastIndex(int k){
        Friend temp = head;
        if (head.next==null){
            throw new RuntimeException("链表为空");
        }
        int sum = count();
        if (sum<k){
            throw new RuntimeException("超出链表长度");
        }
        if (k<=0){
            throw new RuntimeException("查找的序号不能为零或负数");
        }
        int a = 0;
        while (a!=sum+1-k){
            temp=temp.next;
            a++;
        }
        return temp;

    }
}

class Friend{
    public int no;
    public String name;
    public Friend next;

    public Friend(int no, String name) {
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