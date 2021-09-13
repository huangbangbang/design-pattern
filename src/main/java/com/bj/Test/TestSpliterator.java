package com.bj.Test;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TestSpliterator{
    private static String string= "1|2|3 "+"a|b|C "+"100|200|300 "+"jack|tom|mary "+"23|34|55";

    public static void main(String[] args) {


        Line line = new Line(string);
        //System.out.println(Arrays.toString(line.s));
        line.stream().forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        line.parallelStream().forEach(s -> System.out.println(s));

        //line.new TextSpliterator().forEachRemaining(s -> System.out.println(s));


        //System.out.println(line.new TextSpliterator().tryAdvance(a-> System.out.println(a)));
        Spliterator<String> p = line.new TextSpliterator().trySplit();
        System.out.println(p);
    }


    static class Line{
        private final String[] s ;

        public Line(String string) {
            Objects.requireNonNull(string,"can not be empty");
            s=string.split(" ",0);
        }

        public Stream<String> stream(){
            return StreamSupport.stream(new TextSpliterator(),false);
        }

        public Stream<String> parallelStream(){
            return StreamSupport.stream(new TextSpliterator(),true);
        }

        private class TextSpliterator implements Spliterator<String> {
            private int start;
            private int end;

            public TextSpliterator() {
                this.start=0;
                this.end=Line.this.s.length-1;
            }

            public TextSpliterator(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public boolean tryAdvance(Consumer<? super String> action) {
                if (start<=end){
                    action.accept(Line.this.s[start++]);
                    return true;
                }
                return false;
            }

            @Override
            public void forEachRemaining(Consumer<? super String> action) {
                for (int i=start;i<=end;i++){
                    action.accept(Line.this.s[i]);
                }
            }

            @Override
            public Spliterator<String> trySplit() {
                int mid;
                mid=(end-start)/2;
                if (mid<=1){
                    return null;
                }
                int left = start;
                int right = start+mid;
                start+=mid+1;

                return new TextSpliterator(left,right);
            }

            @Override
            public long estimateSize() {
                return end-start;
            }

            @Override
            public long getExactSizeIfKnown() {
                return estimateSize();
            }

            @Override
            public int characteristics() {
                return IMMUTABLE|SIZED|SUBSIZED;
            }

        }
    }
}
