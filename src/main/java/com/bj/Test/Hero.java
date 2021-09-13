package com.bj.Test;

public class Hero implements Cloneable{
    private int no;
    private People people;

    public Hero(int no, People people) {
        this.no = no;
        this.people = people;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "[" +
                "no=" + no +
                ", p=" + people +
                ']';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Hero h = (Hero) super.clone();
        h.people= (People) people.clone();
        //h.setPeople(((Hero) super.clone()).getPeople());
        return h;
    }
}
