package com.bj.algorithm;

import java.util.Arrays;

public class FloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G',};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N =65535;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };
        FGraph fGraph = new FGraph(vertex.length,vertex,matrix);
        fGraph.show();
        fGraph.floyd();
        System.out.println();
        System.out.println("......................................................................");
        fGraph.show();
    }
}

class FGraph{
    public char[] vertex;
    public int[][] dis;
    public int[][] pre;

    public FGraph(int length,char[] vertex, int[][] dis) {
        this.vertex = vertex;
        this.dis = dis;
        this.pre = new int[length][length];
        for (int i =0;i<pre.length;i++){
            Arrays.fill(pre[i],i);
        }
    }
    public void show(){
        char[] vertex = {'A','B','C','D','E','F','G',};
        for (int k=0;k<dis.length;k++){
            for (int i=0;i<dis.length;i++){
                System.out.print(vertex[pre[k][i]]+"\t");
            }
            System.out.println();
        }
        for (int k=0;k<dis.length;k++){
            for (int i=0;i<dis.length;i++){
                //System.out.print(vertex[k]+"-->"+vertex[i]+"="+dis[k][i]+"\t");
                System.out.print(vertex[k]+"-->"+vertex[i]+"=");
                System.out.printf("%5d",dis[k][i]);
                System.out.print("\t\t");
            }
            System.out.println();
        }
    }

    public void floyd(){
        int len=0;
        for (int k=0;k<dis.length;k++){
            for (int i=0;i<dis.length;i++){
                for (int j=0;j<dis.length;j++){
                    len=dis[i][k]+dis[k][j];
                    if (len<dis[i][j]){
                        dis[i][j]=len;
                        pre[i][j]=pre[k][j];
                    }
                }
            }
        }
    }
}