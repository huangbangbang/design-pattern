package com.bj.designpattern;

import java.io.*;

public class ProtoType {
    public static void main(String[] args){
        Proto1 proto1 = new Proto1();
        /*Proto proto = new Proto(1,"jack",proto1);
        Proto clone = (Proto)proto.clone();
        System.out.println(proto.getProto1().hashCode());
        System.out.println(clone.getProto1().hashCode());*/

        Proto proto = new Proto(1, "jack", proto1);
        Proto clone = (Proto) proto.copyObjectByDeserialization();
        System.out.println(proto.getProto1().hashCode());
        System.out.println(clone.getProto1().hashCode());

    }
}

class Proto implements Cloneable ,Serializable{
    private int no;
    private String name;
    private Proto1 proto1;

    public Proto(int no, String name, Proto1 proto1) {
        this.no = no;
        this.name = name;
        this.proto1 = proto1;
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

    public Proto1 getProto1() {
        return proto1;
    }

    public void setProto1(Proto1 proto1) {
        this.proto1 = proto1;
    }

    @Override
    public String toString() {
        return "[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ']';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Proto clone = (Proto) super.clone();
        clone.proto1 = (Proto1) proto1.clone();
        return clone;
    }

    public Object copyObjectByDeserialization(){
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Proto proto = (Proto) ois.readObject();
            return proto;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }finally {
            try {
                bos.close();
                bis.close();
                oos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }
    }
}

class Proto1 implements Cloneable,Serializable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}