package com.bj.datastructure;

public class HebingLinkedList {
    public static void main(String[] args) {
        SingleLinkedList3 singleLinkedList8 = new SingleLinkedList3();
        SingleLinkedList3 singleLinkedList9 = new SingleLinkedList3();
        SingleLinkedList3 singleLinkedList10 = new SingleLinkedList3();
        Friend2 friend21 = new Friend2(1, "jack");
        Friend2 friend22 = new Friend2(2, "jack");
        Friend2 friend23 = new Friend2(3, "jack");
        Friend2 friend24 = new Friend2(4, "jack");
        Friend2 friend25 = new Friend2(5, "jack");
        Friend2 friend26 = new Friend2(6, "jack");
        Friend2 friend27 = new Friend2(7, "jack");
        Friend2 friend28 = new Friend2(8, "jack");
        Friend2 friend29 = new Friend2(9, "jack");
        Friend2 friend210 = new Friend2(10, "jack");
        Friend2 friend212 = new Friend2(12, "jack");
        Friend2 friend214 = new Friend2(14, "jack");
        singleLinkedList8.add(friend21);
        singleLinkedList9.add(friend22);
        singleLinkedList8.add(friend23);
        singleLinkedList9.add(friend24);
        singleLinkedList8.add(friend25);
        singleLinkedList9.add(friend26);
        singleLinkedList8.add(friend27);
        singleLinkedList9.add(friend28);
        singleLinkedList8.add(friend29);
        singleLinkedList9.add(friend210);
        singleLinkedList9.add(friend212);
        singleLinkedList9.add(friend214);
        System.out.println("a linkedList.................................");
        singleLinkedList8.show();
        System.out.println("b linkedList.....................................");
        singleLinkedList9.show();
        Friend2 temp1 = singleLinkedList8.getHead();
        temp1=temp1.next;
        Friend2 temp2 = singleLinkedList9.getHead();
        temp2=temp2.next;
        Friend2 cur1;
        Friend2 cur2;
        while (temp1!=null&&temp2!=null){
            if (temp1.no<temp2.no){
                cur1=temp1.next;
                temp1.next=null;
                singleLinkedList10.add(temp1);
                temp1=cur1;
            }else {
                cur2=temp2.next;
                temp2.next=null;
                singleLinkedList10.add(temp2);
                temp2=cur2;
            }
        }
        if(temp1==null){
            singleLinkedList10.add(temp2);
        }else {
            singleLinkedList10.add(temp1);
        }
        System.out.println("a+b linkedList.................................");
        singleLinkedList10.show();

    }
}
