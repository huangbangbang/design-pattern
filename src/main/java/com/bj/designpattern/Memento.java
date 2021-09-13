package com.bj.designpattern;

import java.util.HashMap;

public class Memento {
    private static int count=0;
    public static void main(String[] args) {
        GameRole gameRole = new GameRole(100);
        GameRoleMemento gameRoleMemento = gameRole.setGameRoleMemento();
        GameRoleMementoContainer gameRoleMementoContainer = new GameRoleMementoContainer();
        gameRoleMementoContainer.add(++count,gameRoleMemento);
        gameRole.daBoss();
        gameRole.daBoss();
        gameRole.daBoss();
        System.out.println(gameRole);
        gameRoleMementoContainer.add(++count,gameRole.setGameRoleMemento());
        gameRole.daBoss();
        gameRole.daBoss();
        gameRole.daBoss();
        System.out.println(gameRole);
        gameRole.recoverFromGameRoleMemento(gameRoleMementoContainer.get(count-1));
        System.out.println(gameRole);

    }
}

class GameRole {
    private int blood;

    public GameRole(int blood) {
        this.blood = blood;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return "GameRole[" +
                "blood=" + blood +
                ']';
    }

    public void daBoss(){
        blood-=10;
    }
    public GameRoleMemento setGameRoleMemento(){
        return new GameRoleMemento(this.blood);
    }

    public void recoverFromGameRoleMemento(GameRoleMemento gameRoleMemento){
        this.blood = gameRoleMemento.getBlood();
    }
}

class GameRoleMemento{
    private int blood;

    public GameRoleMemento(int blood) {
        this.blood = blood;
    }

    public int getBlood() {
        return blood;
    }
}

class GameRoleMementoContainer{
    private HashMap<Integer, GameRoleMemento> hashMap  =new HashMap();
    public void add(int i , GameRoleMemento gameRoleMemento){
        hashMap.put(i,gameRoleMemento);
    }
    public GameRoleMemento get(int i ){
       return hashMap.get(i);
    }
}