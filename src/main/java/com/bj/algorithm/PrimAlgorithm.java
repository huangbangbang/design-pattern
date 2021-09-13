package com.bj.algorithm;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertexes = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        Graph graph = new Graph(vertexes, data, weight);
        MinCostTree minCostTree = new MinCostTree();
        minCostTree.ShowGraph(graph);
        minCostTree.prim(graph,1);
    }

}

class MinCostTree {
    public void ShowGraph(Graph graph) {
        for (int[] row : graph.weight) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void prim(Graph graph, int v) {
        int[] visited = new int[graph.vertexes];
        visited[v] = 1;
        int minWeight = 10000;
        int h1 = -1;
        int h2 = -1;
        for (int k = 1; k < graph.vertexes; k++) {
            for (int i = 0; i < graph.vertexes; i++) {
                for (int j = 0; j < graph.vertexes; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            visited[h2]=1;
            minWeight=10000;
            System.out.println("<" + graph.data[h1] + "," + graph.data[h2] + ">   " + graph.weight[h1][h2]);
        }
    }
}

class Graph {
    public int vertexes;
    public char[] data;
    public int[][] weight;

    public Graph(int vertexes, char[] data, int[][] weight) {
        this.vertexes = vertexes;
        this.data = data;
        this.weight = weight;
    }
}
