package com.bj.Test;

public class Test13 {
    public static void main(String[] args) throws CloneNotSupportedException {
        /*BigInteger bigInteger = new BigInteger("41");
        BigInteger bigInteger1 = new BigInteger("5");
        BigInteger remainder = bigInteger.remainder(bigInteger1);
        System.out.println(remainder);*//*
        ArrayList<Integer> arrayList = new ArrayList(10);
        *//*arrayList.add(null);
        arrayList.add(null);
        System.out.println(arrayList);
        arrayList.remove(null);
        arrayList.remove(null);
        arrayList.remove(null);
        System.out.println(arrayList);*//*
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(3);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        arrayList.forEach(a-> System.out.println(a));
//        arrayList.sort(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return o1.hashCode()-o2.hashCode();
//            }
//        });
//        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println(arrayList);
*/
        /*ArrayList<Student> arrayList = new ArrayList();
        Student student1 = new Student(1, "jack", 25);
        Student student2 = new Student(7, "tom", 25);
        Student student3 = new Student(3, "mary", 25);
        Student student4 = new Student(5, "bob", 25);
        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);
        arrayList.add(student4);*/
        //ArrayList clone = (ArrayList)arrayList.clone();
        People people = new People(1,"jack");
        Hero hero = new Hero(1,people);
        Hero clone = (Hero) hero.clone();
        hero.setNo(2);
        people.setName("mary");
        //hero.setPeople(new People(2,"mary"));
        System.out.println(hero);
        System.out.println(clone);

    }
}
