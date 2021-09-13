package com.bj.Test;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

class Student2 implements Cloneable{
    private int age;
    private String name;
    private boolean sex;

    public Student2(int age, String name, boolean sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public Student2() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "[" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ']';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student2 s = (Student2) super.clone();
        return s;
    }
}

public class Test01 {
    @Test
    public void testPredicate() {
        Predicate<Long> predicate = x -> x == 1L;
        System.out.println(predicate.test(2L));
    }


    public static int doubleNum(int i){
        System.out.println("执行了乘以2");
        return i*2;
    }
    public static void debug(int i) {
        System.out.println(Thread.currentThread().getName() + "debug:" + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void debug2(int i) {
        System.err.println("debug2:" + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){

        String string = "i am a hero";
        /*System.out.println("............................map.............................................");
        Stream.of(string.split(" ")).map(s->s.length()).forEach(s-> System.out.println(s));
        System.out.println("............................filter.............................................");
        Stream.of(string.split(" ")).filter(s -> s.length()>1).map(s->s.length()).forEach(s-> System.out.println(s));
        System.out.println("............................flatMap.............................................");
        Stream.of(string.split(" ")).flatMap(s -> s.chars().boxed()).forEach(s-> System.out.println((char) s.intValue()));
        */
        /*System.out.println("............................peek.............................................");
        Stream.of(string.split(" ")).peek(System.out::println).forEach(System.out::println);*/
        /*System.out.println("............................limit.............................................");
        new Random().ints().filter(i->i>1000&&i<2000).limit(10).forEach(i-> System.out.println(i));
        System.out.println("............................limit.............................................");
        new Random().ints().filter(i->i>1000&&i<2000).limit(10).forEach(System.out::println);*/

        /*string.chars().parallel().forEach(s-> System.out.println((char) s));
        System.out.println("-----------------------------------------------------------------------------------");
        string.chars().parallel().forEachOrdered(s-> System.out.println((char) s));*/
        /*List<String> list = Stream.of(string.split(" ")).collect(Collectors.toList());
        System.out.println(list);*/
        /*Optional<String> reduce = Stream.of(string.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce.orElse(""));*/
        /*String reduce = Stream.of(string.split(" ")).reduce("", (s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce);*/
        /*Integer reduce = Stream.of(string.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(reduce);*/
        /*Optional<String> max = Stream.of(string.split(" ")).max((s1, s2) -> s1.length() - s2.length());
        System.out.println(max.get());*/
        /*OptionalInt first = new Random().ints().findFirst();
        System.out.println(first.getAsInt());*/



        /*ForkJoinPool pool=new ForkJoinPool(20);
        pool.submit(()->IntStream.range(1,100).sequential().peek(Test::debug2).count());
        pool.shutdown();
        synchronized (pool){
            try {
                pool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        /*List<Student2> students = Arrays.asList(
                new Student2(23, "里斯", true),
                new Student2(24, "王二", false),
                new Student2(20, "小明", false),
                new Student2(2, "校长", false),
                new Student2(3, "小王", true),
                new Student2(29, "小白", true));
        List<Integer> ages = students.stream().map(Student2::getAge).collect(Collectors.toList());
        System.out.println(ages);
        IntSummaryStatistics collect = students.stream().collect(Collectors.summarizingInt(Student2::getAge));
        System.out.println(collect);
        //分块：根据一个规则，把数据分成两块
        Map<Boolean, List<Student2>> genders = students.stream().collect(Collectors.partitioningBy(s ->s.isSex()==true));
        System.out.println(genders);
        //分组
        Map<Boolean, List<Student2>> collect1 = students.stream().collect(Collectors.groupingBy(Student2::isSex));
        System.out.println(collect1);
        Map<Boolean, Long> collect2 = students.stream().collect(Collectors.groupingBy(Student2::isSex, Collectors.counting()));
        System.out.println(collect2);*/


        /*ArrayList<Object> list = new ArrayList<>();
        list.stream();
        list.parallelStream();
        Arrays.stream(new int[]{1,2,3,4});
        IntStream.of(1,2,3,4);
        IntStream.rangeClosed(1,10);
        IntStream.range(1,10);
        Random random = new Random();
        random.ints().limit(10);
        Stream.generate(()->random.nextInt()).limit(10);*/
        /*// 使用stream内部迭代
        // map 就是中间操作，（返回stream的操作）
        // sum就是终止操作，直接返回结果
        int[] a ={1,2,3,4,5};
        //惰性求值 ：惰性求值就是终止操作没有调用的情况写，中间操作不做执行
        IntStream intStream = IntStream.of(a).map(i -> doubleNum(i));
        System.out.println(intStream);*/
        /*int[] a ={1,2,3,4,5};
        IntStream intStream = IntStream.of(a).map(i -> i * 2);
        int sum = intStream.sum();
        System.out.println(sum);
        System.out.println(Arrays.toString(a));*/
        /*int sum = IntStream.of(a).sum();
        System.out.println(sum);*/
        /*Object[] a= new Object[4];
        a[0]='a';
        a[1]=1;
        a[2]=1.2;
        a[3]=true;
        System.out.println(Arrays.toString(a));*/
        /*int[] a ={5,8,4,2,9};
        Arrays.sort(a);
        int i = Arrays.binarySearch(a, 2);
        System.out.println(i);
        System.out.println(Arrays.toString(a));*/


















        /*String a = "abc";
        String b = a.concat("def");
        System.out.println(b);*/
        /*boolean b = true;
        String s = String.valueOf(b);
        System.out.println(s);*/
        /*char[] a = {'j','a','c','k'};
        int b=2;
        String s = String.valueOf(a);
        System.out.println(s);
        System.out.println();*/
        /*Student jack = new Student(1, "jack", 24);
        String s = String.valueOf(jack);
        System.out.println(s);*/
        /*String s = "123";
        Integer i = Integer.parseInt(s);
        System.out.println(i);*/
        /*int a =1000;
        Integer b =1000;
        char c = 'a';
        boolean f = true;
        String s = String.valueOf(a);
        String s1 = String.valueOf(b);
        String s2 = String.valueOf(c);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(String.valueOf(f));*/
        /*String s = "jackhjgkhgksdaf";
        String format = String.format("%-20s", s);
        System.out.println(format);*/
        /*int num = 12;
        String format = String.format("%04d", num);
        System.out.println(format);*/
        /*int num = -100000000;
        String format = String.format("%(,d", num);
        System.out.println(format);*/
        /*double num = 100.2544444444444444;
        String format = String.format("%f", num);
        System.out.println(format);
        System.out.println(String.format("%f", num));*/
        /*Date date = new Date();
        String format = String.format("%tD", date);
        System.out.println(format);*/
        /*int num = 1000;
        String str = String.format("%d %<,d", num);
        System.out.println(str);
        System.out.printf("%5d  %d",num,num);*/
        /*String s =" ab12 12 34 234 23 234 23    ";
        String s1 = s.trim();
        System.out.println(s1);
        System.out.println((int)' ');
        System.out.println(s.getBytes());*/
        /*String[] s = {"jack","tony","mary"};
        String s1 = String.join("-", s);
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(String.join("-",list));
        System.out.println(s1);*/
        /*String s ="12,12,34,234,23,234,23,";
        String[] split = s.split(",", 0);
        System.out.println(Arrays.toString(split));*/
        /*String s ="akAajgshfsafgdf";
        String s1 = s.replace("f","123");
        System.out.println(s);
        System.out.println(s1);*/
        /*int[] a = {1,2,3,4};
        System.out.println(a.hashCode());*/
        /*char a ='c';
        char b ='中';
        String c ="c";
        String d = "中";
        byte[] a1;
        a1=charToByte(a);
        byte[] b1;
        b1=charToByte(b);
        byte[] c1=c.getBytes();
        byte[] d1=d.getBytes();
        System.out.println(a1.length);
        System.out.println(b1.length);
        System.out.println(c1.length);
        System.out.println(d1.length);
        char[] c = {'j','a','c','k'};
        byte[] b = new byte[4];
        b[1]=(byte)c[1];
        System.out.println(c[1]);
        System.out.println(b[1]);
        String s =null;*/
        /*byte[] b = {111,00,11,1};
        String s = new String(b, StandardCharsets.UTF_8);
        System.out.println(s);*/
        /*String s ="jack";
        System.out.println(s.length());
        System.out.println(s.codePointCount(0,3));*/

       /* int[][][] a= new int[10][10][10];
        int count =0;
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length;j++){
                for (int k =0;k<a.length;k++){
                    a[i][j][k] = count++;
                }
            }

        }
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length;j++){
                for (int k =0;k<a.length;k++){
                    System.out.print(a[i][j][k]+"\t");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }*/

    }

    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }
}
