package com.bj.datastructure;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
        Node root = createHuffmanTree(arr);
        System.out.println(root);
        root.preOrder();
    }

    private static Node createHuffmanTree(int[] arr) {


        ArrayList<Node> nodes = new ArrayList<>();
        for (int val:arr){
            nodes.add(new Node(val));
        }

        while (nodes.size()>1){
            Collections.sort(nodes);
            System.out.println(nodes);

            Node node0 = nodes.get(0);
            Node node1 = nodes.get(1);

            Node parent = new Node(node0.value + node1.value);
            parent.left=node0;
            parent.right=node1;

            nodes.remove(node0);
            nodes.remove(node1);
            nodes.add(parent);
        }
        return nodes.get(0);

    }
}


class Node implements Comparable<Node>{
    public int value;

    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public void preOrder(){
        System.out.println(this.value);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "[" +
                "value=" + value +
                ']';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}