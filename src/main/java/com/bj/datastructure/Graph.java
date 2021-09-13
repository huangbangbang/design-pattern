package com.bj.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdge;
    private boolean[] isVisit;
    static int num;

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        String[] vertexes = {"A", "B", "C", "D", "E","F","G","H"};
        for (String s : vertexes) {
            graph.insertVertex(s);
        }

        /*graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);*/
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        graph.showGraph();
        graph.dfs();
        System.out.println("..............................");
        graph.bfs();
        //System.out.println(num);

    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdge = 0;
    }

    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    private void dfs(boolean[] isVisit, int i) {

        System.out.print(getValueByIndex(i) + "-->");
        isVisit[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisit[w]) {
                dfs(isVisit, w);
            }
            w = getNextNeighbor(i, w);
            num++;
        }
    }

    public void dfs() {
        isVisit = new boolean[vertexList.size()];
        for (int i = 0; i < isVisit.length; i++) {
            if (!isVisit[i]) {
                dfs(isVisit, i);
            }
        }
    }
    private void bfs(boolean[] isVisit, int i) {
        int u;
        int w;
        LinkedList queue = new LinkedList<>();
        isVisit[i]=true;
        System.out.print(getValueByIndex(i) + "-->");
        queue.addLast(i);
        while (!queue.isEmpty()) {
                u= (Integer) queue.removeFirst();
                w=getFirstNeighbor(u);
                if (!isVisit[w]){
                    isVisit[w]=true;
                    System.out.print(getValueByIndex(w)+"--->");
                    queue.addLast(w);
                }
                w=getNextNeighbor(u,w);
        }
    }
    public void bfs() {
        isVisit = new boolean[vertexList.size()];
        for (int i = 0; i < isVisit.length; i++) {
            if (!isVisit[i]) {
                bfs(isVisit, i);
            }
        }
    }



    public void insertEdge(int a, int b, int weight) {
        edges[a][b] = weight;
        edges[b][a] = weight;
        numOfEdge++;
    }

    public void showGraph() {
        for (int[] row : edges) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int getNumOfEdge() {
        return numOfEdge;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public int getWeight(int a, int b) {
        return edges[a][b];
    }
}
