package com.bj.Test;

import java.util.LinkedList;

public class Test14 {
    public static void main(String[] args) {

        /*Function<Integer,Integer> function = a->a*10;
        function.apply(10);
        System.out.println(function.apply(100));

        Consumer<Integer> consumer = a-> System.out.println(2*a);
        consumer.accept(100);

        Supplier supplier = ()->100;
        supplier.get();
        System.out.println(supplier.get());

        Predicate<Integer> predicate = i->i*2==4;
        predicate.test(2);
        System.out.println(predicate.test(3));
        ArrayList<String> list = new ArrayList<>();
        list.add("tom");
        list.add("jack");
        list.add("mary");
        list.add("smith");
        Collections.sort(list);
        System.out.println(list);*/
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=0;i<8000;i++){
            linkedList.add(i);
        }
        System.out.println(linkedList.pop());
        /*Iterator<Integer> descendingIterator = linkedList.descendingIterator();
        descendingIterator.forEachRemaining(s-> System.out.println(s));*/
        //linkedList.forEach(s-> System.out.println(s));
        //System.out.println(linkedList.size());
    }
}
