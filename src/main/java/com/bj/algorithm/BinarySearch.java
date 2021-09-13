package com.bj.algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 8, 8, 8, 8, 8, 8, 10, 19, 100};
        //int res = binarySearch(arr,0,arr.length-1,3);
        //ArrayList<Integer> list = binarySearch2(arr,0,arr.length-1,8);
        ArrayList<Integer> list = binarySearchNotRecursion(arr, 8);
        Collections.sort(list);
        System.out.println(list);
        //System.out.println(res);
        //ArrayList<Student> studentList = new ArrayList<Student>();
        //ArrayList<Student1> student1List = new ArrayList<Student1>();
        /*studentList.add(new Student(2,"jack",11));
        studentList.add(new Student(1,"mary",12));
        studentList.add(new Student(3,"tom",13));
        studentList.add(new Student(3,"bob",14));
        studentList.add(new Student(5,"smith",13));
        student1List.add(new Student1(2,"jack",11));
        student1List.add(new Student1(1,"mary",12));
        student1List.add(new Student1(3,"tom",13));
        student1List.add(new Student1(3,"bob",14));
        student1List.add(new Student1(5,"smith",13));*/
        //Collections.sort(list);
        //Collections.sort(studentList);

        /*Collections.sort(student1List, new Comparator<Student1>() {
            @Override
            public int compare(Student1 o1, Student1 o2) {
                int i = o1.getNo() - o2.getNo();
                if (i == 0) {
                    return o1.getAge() - o2.getAge();
                }
                return i;
            }
        });*/
        //System.out.println(list);
        //System.out.println(student1List);
    }

    private static ArrayList<Integer> binarySearchNotRecursion(int[] arr, int search) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < search) {
                left = mid + 1;
            } else if (search < arr[mid]) {
                right = mid - 1;
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                int index = mid - 1;
                while (true) {
                    if (index < left || arr[index] != arr[mid]) {
                        break;
                    }
                    list.add(index);
                    index--;
                }
                list.add(mid);
                index = mid + 1;
                while (true) {
                    if (index > right || arr[index] != arr[mid]) {
                        break;
                    }
                    list.add(index);
                    index++;
                }
                return list;
            }

        }
        return null;
    }

    private static int binarySearch(int[] arr, int left, int right, int search) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (arr[mid] < search) {
            return binarySearch(arr, mid + 1, right, search);
        } else if (arr[mid] > search) {
            return binarySearch(arr, left, mid, search);
        } else {
            return mid;
        }
    }

    private static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int search) {
        int mid = (left + right) / 2;
        if (left > right) {
            return null;
        }
        if (arr[mid] < search) {
            return binarySearch2(arr, mid + 1, right, search);
        } else if (arr[mid] > search) {
            return binarySearch2(arr, left, mid, search);
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int index = mid - 1;
            while (true) {
                if (index < left || arr[index] != arr[mid]) {
                    break;
                }
                list.add(index);
                index--;
            }
            list.add(mid);
            index = mid + 1;
            while (true) {
                if (index > right || arr[index] != arr[mid]) {
                    break;
                }
                list.add(index);
                index++;
            }
            return list;
        }
    }
}

class Student implements Comparable<Student> {
    private int no;
    private String name;
    private int age;

    public Student(int no, String name, int age) {
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

    @Override
    public int compareTo(Student o) {
        int i = this.getNo() - o.getNo();
        if (i == 0) {
            return this.getAge() - o.getAge();
        }
        return i;
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

class Student1 {
    private int no;
    private String name;
    private int age;

    public Student1(int no, String name, int age) {
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


    @Override
    public String toString() {
        return "[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ']';
    }
}