package com.bj.algorithm;

import java.util.Arrays;

public class DijksraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G',};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N =65535;
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};

        DGraph dGraph = new DGraph(vertex,matrix);
        dGraph.showGraph();
        dGraph.dijkstra(0);
        dGraph.showDijkstra();
    }
}

class DGraph{
    public char[] vertex;
    public int[][] matrix;
    public VisitedVertex vv;

    public DGraph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }
    public void showGraph(){
        for (int[] row:matrix){
            System.out.println(Arrays.toString(row));
        }
    }

    public void showDijkstra(){
        vv.show();
    }
    public void dijkstra(int index){
        vv=new VisitedVertex(vertex.length,index);
        update(index);
        for (int j =1;j<vertex.length;j++){
            index = vv.updateArr();
            update(index);
        }
    }

    private void update(int index) {
        int len=0;
        for (int j =0;j<matrix[index].length;j++){
            len = vv.getDis(index)+matrix[index][j];
            if (!vv.in(j)&&len<vv.getDis(j)){
                vv.updatePre(j,index);
                vv.updateDis(j,len);
            }
        }
    }
}

class VisitedVertex{
    public int[] alreadyVisited;
    public int[] preVisited;
    public int[] dis;

    public VisitedVertex(int length, int index) {
        this.alreadyVisited = new int[length];
        this.preVisited = new int[length];
        this.dis = new int[length];

        Arrays.fill(dis,65535);
        this.alreadyVisited[index]=1;
        this.dis[index]=0;
    }

    public boolean in(int index){
        return alreadyVisited[index]==1;
    }

    public void updateDis(int index,int len){
        dis[index]=len;
    }

    public void updatePre(int pre,int index){
        preVisited[pre]=index;
    }

    public int getDis(int index){
        return dis[index];
    }
    public int updateArr(){
        int index = 0;
        int min = 65535;
        for (int i =0 ;i<alreadyVisited.length;i++){
            if (alreadyVisited[i]==0&&dis[i]<min){
                min=dis[i];
                index=i;
            }
        }
        alreadyVisited[index]=1;
        return index;
    }

    public void show(){
        for (int  i:alreadyVisited){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(preVisited));
        System.out.println(Arrays.toString(dis));

        char[] vertex = {'A','B','C','D','E','F','G',};
        int count=0;
        for (int i:dis){
            if (i!=65535){
                System.out.print(vertex[count]+"("+i+")");
            }else {
                System.out.println("N");
            }
            count++;
        }
    }
}