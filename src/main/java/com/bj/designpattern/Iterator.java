package com.bj.designpattern;

public class Iterator {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,56,7,32,5,9};
        /*Array array = new Array(ints);
        Array.AIterator iterator = array.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        Array1 array1 = new Array1(ints);
        array1.iterator();
        while (array1.aIterator1.hasNext()){
            System.out.println(array1.aIterator1.next());
        }
    }
}

class Array{
    private int[] arr;

    public Array(int[] arr) {
        this.arr = arr;
    }

    public AIterator iterator(){
        return new AIterator();
    }

    class AIterator {
        int i =0;
        public boolean hasNext(){
            return i<arr.length;
        }

        public int next(){
            int a = arr[i];
            i+=2;
            return a;
        }
    }
}

class Array1{

    private int[] arr;

    public AIterator1 aIterator1;

    public Array1(int[] arr) {
        this.arr = arr;
    }

    public void iterator(){
        aIterator1= new AIterator1() {
            int i =0;
            public boolean hasNext(){
                return i<arr.length;
            }

            public int next(){
                int a = arr[i];
                i++;
                return a;
            }
        };
    }


}

interface AIterator1 {

    public boolean hasNext();

    public int next();
}