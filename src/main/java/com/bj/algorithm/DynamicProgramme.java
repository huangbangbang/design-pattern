package com.bj.algorithm;

public class DynamicProgramme {
    public static void main(String[] args) {
        int[] weight = {1, 4, 3};
        int[] value = {1500, 3000, 2000};
        int capacity =4;
        int num = weight.length;
        int[][] v = new int[num+1][capacity+1];
        int[][] path = new int[num+1][capacity+1];

        for (int i=1;i<v.length;i++){
            for (int j=1;j<v[0].length;j++){
                if (j<weight[i-1]){
                    v[i][j]=v[i-1][j];
                }else {
                    if (v[i-1][j]<value[i-1]+v[i-1][j-weight[i-1]]){
                        v[i][j]=value[i-1]+v[i-1][j-weight[i-1]];
                        path[i][j]=1;
                    }else {
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }
        for (int i=0;i<v.length;i++){
            for (int j=0;j<v[0].length;j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }

        /*for (int i=0;i<path.length;i++){
            for (int j=0;j<path[i].length;j++){
                if (path[i][j]==1){
                    System.out.println(i+"join");
                }
            }
            System.out.println();
        }*/

        int i = path.length-1;
        int j = path[0].length-1;
        while (i>0&&j>0){
            if (path[i][j]==1){
                System.out.println(i+"join");
                j-=weight[i-1];
            }
            i--;
        }

    }
}
