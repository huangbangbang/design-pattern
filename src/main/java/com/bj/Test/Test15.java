package com.bj.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class Test15 implements Runnable{
    private static ArrayList<Integer> arrayList;
    public static void main(String[] args) {
        arrayList = new ArrayList<>();
        for (int i=0;i<800;i++) {
            arrayList.add(i);
        }
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println(arrayList);
        /*Thread thread = new Thread( new Test15());
        thread.start();
        ListIterator<Integer> listIterator = arrayList.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        arrayList.forEach(s-> System.out.println(s));*/

        /*Vector<Integer> vector = new Vector<>();
        for (int i=0;i<8000;i++) {
            vector.add(i);
        }
        Enumeration<Integer> elements = vector.elements();
        //System.out.println(elements);
        while (elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }*/
    }

    @Override
    public void run() {
        arrayList.add(799999);
        arrayList.remove(180400);
        arrayList.remove(308000);
        arrayList.remove(500800);
    }
}
