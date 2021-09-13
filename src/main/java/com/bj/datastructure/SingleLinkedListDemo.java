package com.bj.datastructure;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "公孙胜", "入云龙");

        SingleLinkedList singleLinkedList = new SingleLinkedList(new HeroNode(0, "", ""));

        singleLinkedList.addNodeByOrder(heroNode3);
        singleLinkedList.addNodeByOrder(heroNode4);
        singleLinkedList.addNodeByOrder(heroNode1);
        singleLinkedList.addNodeByOrder(heroNode2);

        singleLinkedList.show();

        singleLinkedList.del(1);
        singleLinkedList.del(5);
        System.out.println("...................................");
        singleLinkedList.show();
        singleLinkedList.update(new HeroNode(4,"林冲","豹子头" ));
        System.out.println("...................................");
        singleLinkedList.show();
    }
}

class SingleLinkedList{
    private HeroNode headNode;

    public SingleLinkedList(HeroNode headNode) {
        this.headNode = headNode;
    }

    /*public void addNode(HeroNode heroNode){
        HeroNode temp = new HeroNode();
        temp=headNode;
        while (temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(heroNode);
    }*/

    /*public void addNodeByOrder(HeroNode heroNode){
        HeroNode temp = new HeroNode();
        temp=headNode;

        while (temp.getNext()!=null&&temp.getNext().getNo()<heroNode.getNo()){
            temp=temp.getNext();

        }
        if (temp.getNext()==null){
            temp.setNext(heroNode);
        }else {
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }*/

    public void addNodeByOrder(HeroNode heroNode){
        HeroNode temp = new HeroNode();
        temp=headNode;

        boolean flag = false;
        while(true){
            if (temp.getNext()==null){
                break;
            }
            if (temp.getNext().getNo()>heroNode.getNo()){
                break;
            }else if(temp.getNext().getNo()==heroNode.getNo()){
                flag=true;
            }
            temp=temp.getNext();
        }
        if (flag){
            System.out.println("always exist");
        }else {
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }
    public void show(){
        if (headNode.getNext()==null){
            System.out.println("SingleLinkedList is empty");
            return;
        }
        HeroNode temp = new HeroNode();
        temp=headNode.getNext();
        do{
            System.out.println(temp);
            temp=temp.getNext();
        }while (temp!=null);
    }

    public void update(HeroNode heroNode){
        HeroNode temp = headNode.getNext();
        boolean flag = false;
        while (true){
            if (temp==null){
                break;
            }
            if (temp.getNo()==heroNode.getNo()){
                flag=true;
                break;
            }
            temp=temp.getNext();
        }
        if (flag){
            temp.setName(heroNode.getName());
            temp.setNickName(heroNode.getNickName());
        }else {
            System.out.println("not exist");
        }
    }
    public void del(int no){
        HeroNode temp  = headNode;
        boolean flag=false;
        while (true){
            if (temp.getNext()==null){
                break;
            }
            if (temp.getNext().getNo()==no){
                flag=true;
                break;
            }
            temp=temp.getNext();
        }
        if (flag){
            temp.setNext(temp.getNext().getNext());
        }else {
            System.out.println("not exist");
        }
    }
}

class HeroNode{
    private int no;
    private String name;
    private String nickName;
    private HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode() {
    }

    @Override
    public String toString() {
        return "[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ']';
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public HeroNode getNext() {
        return next;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}