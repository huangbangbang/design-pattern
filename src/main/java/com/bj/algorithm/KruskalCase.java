package com.bj.algorithm;

import java.util.Arrays;

public class KruskalCase {

    private int edgeNum;
    private char[] vertexes;
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;


    public KruskalCase(char[] vertexes, int[][] matrix) {
        this.vertexes = vertexes;
        this.matrix = matrix;

        for (int i = 0; i < vertexes.length; i++) {
            for (int j = i+1; j < vertexes.length; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        KruskalCase kruskalCase = new KruskalCase(vertexes, matrix);

        kruskalCase.print();
        kruskalCase.kruskal();
    }

    private void kruskal() {
        int index = 0;
        int[] end = new int[edgeNum];
        Edge[] ret = new Edge[edgeNum];
        Edge[] edges = getEdges();
        //System.out.println(Arrays.toString(edges)+edges.length);
        sortEdge(edges);
        for (int i=0;i<edges.length;i++){
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            int m = getEnd(end,p1);
            int n = getEnd(end,p2);
            if (m!=n){
                end[m]=n;
                ret[index++]=edges[i];
            }
        }
        for (int i =0;i<index;i++){
            System.out.println(ret[i]);;
        }
    }

    private void print() {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private void sortEdge(Edge[] edges) {
        Edge temp;
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    private int getPosition(char c) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == c) {
                return i;
            }
        }
        return -1;
    }

    private Edge[] getEdges(){
        int index = 0;
        Edge[] edge = new Edge[edgeNum];
        for (int i =0;i<vertexes.length;i++){
            for (int j=i+1;j<vertexes.length;j++){
                if (matrix[i][j]!=INF){
                    edge[index++]= new Edge(vertexes[i],vertexes[j],matrix[i][j]);
                }
            }
        }
        return edge;
    }
    private int getEnd(int[] end,int i){
        while (end[i]!=0){
            i=end[i];
        }
        return i;
    }

}


class Edge {
    public char start;
    public char end;
    public int weight;

    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "<" + start + "-->" + end + "> weight=" + weight;
    }
}