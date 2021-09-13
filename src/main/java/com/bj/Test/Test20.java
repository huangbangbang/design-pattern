package com.bj.Test;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Test20 {
    public static void main(String[] args) {
        /*boolean isSafe = false;
        assert isSafe;
        System.out.println("断言通过!");*/
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        Spliterator.OfInt spliterator = Spliterators.spliterator(a, Spliterator.SIZED);
        Spliterator.OfInt ofInt = spliterator.trySplit();
        Stream<Integer> stream = StreamSupport.stream(ofInt, true);
        stream.forEach(s-> System.out.println(s));
        System.out.println("---------------------------------------------------------------");
        Stream<Integer> stream1 = StreamSupport.stream(spliterator, true);
        stream1.forEach(s-> System.out.println(s));
        //spliterator.forEachRemaining((IntConsumer) s-> System.out.println(s));
        //ofInt.forEachRemaining((IntConsumer)s-> System.out.println(s));
    }

}
