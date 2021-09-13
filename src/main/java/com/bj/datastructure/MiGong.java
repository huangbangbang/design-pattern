package com.bj.datastructure;

public class MiGong {

    public static void main(String[] args) {
        int[][] map = new int[10][10];
        for (int i=0;i<map.length;i++){
            map[0][i]=1;
            map[9][i]=1;
        }
        for (int i=0;i<map.length;i++){
            map[i][0]=1;
            map[i][9]=1;
        }
        map[5][1]=1;
        map[5][2]=1;
        map[5][3]=1;
        map[3][1]=1;
        map[3][2]=1;
        map[3][3]=1;
        map[4][3]=1;
        for (int[] row: map){
            for (int data: row){
                System.out.print(data+" ");
            }
            System.out.println();
        }
        setLoad(map,4,1);
        System.out.println("...........................");
        for (int[] row: map){
            for (int data: row){
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }


    public static boolean setLoad(int[][] map,int i,int j){
        if (map[8][8]==2){
            return true;
        }else {
            if (map[i][j]==0){
                map[i][j]=2;
                if (setLoad(map, i+1, j)){
                    return true;
                }else if (setLoad(map, i, j+1)){
                    return true;
                }else if(setLoad(map,i-1,j)){
                    return true;
                }else if (setLoad(map,i,j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }

            }
            else {
                return false;
            }
        }
    }
}
