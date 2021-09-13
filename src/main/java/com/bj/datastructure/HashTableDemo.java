package com.bj.datastructure;


public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(8);
        Emp emp1 = new Emp(1, "jack", 27);
        Emp emp2 = new Emp(2, "tom", 17);
        Emp emp3 = new Emp(3, "mary", 37);
        Emp emp4 = new Emp(4, "smith", 24);
        Emp emp5 = new Emp(11, "tony", 24);
        Emp emp6 = new Emp(10, "linda", 44);
        Emp emp7 = new Emp(9, "trump", 14);
        hashTable.add(emp1);
        hashTable.add(emp2);
        hashTable.add(emp3);
        hashTable.add(emp4);
        hashTable.add(emp5);
        hashTable.add(emp6);
        hashTable.add(emp7);

        Emp emp = hashTable.get(4);
        System.out.println(emp);

        hashTable.show();
    }
}

class HashTable{
    private int max;
    private LinkedList[] linkedLists;

    public HashTable(int max) {
        this.max = max;
        linkedLists=new LinkedList[this.max];
        for (int i=0;i<max;i++){
            linkedLists[i]=new LinkedList();
        }
    }
    public void add(Emp emp){
        linkedLists[emp.getNo()%max].add(emp);
    }
    public Emp get(int no){
        return linkedLists[no%max].findById(no);
    }
    public void show(){
        for (int i=0;i<max;i++){
            System.out.println("第"+i+"条:");
            linkedLists[i].list();
            System.out.println();
        }
    }
}

class LinkedList{
    private Emp head;

    public LinkedList() {
    }

    public void add(Emp emp){
        Emp temp=head;
        if (head==null){
            head=emp;
            return;
        }
        while (temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(emp);
    }
    public void list(){
        Emp temp=head;
        if (head==null){
            System.out.print("empty");
        }
        while (temp!=null){
            System.out.print(temp+" ");
            temp=temp.getNext();
        }
    }
    public Emp findById(int no){
        Emp temp=head;
        if (head==null){
            return null;
        }
        while (temp!=null){
            if (temp.getNo()==no){
                break;
            }
            temp=temp.getNext();
        }
        return temp;
    }
}

class Emp{
    private int no;
    private String name;
    private int age;
    private Emp next;

    public Emp(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ']';
    }
}
