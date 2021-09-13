package com.bj.datastructure;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        Teacher teacher1 = new Teacher(4, "jack");
        Teacher teacher2 = new Teacher(2, "jack");
        Teacher teacher3 = new Teacher(5, "jack");
        Teacher teacher4 = new Teacher(1, "tom");
        Teacher teacher5 = new Teacher(3, "jack");
        Teacher teacher6 = new Teacher(6, "jack");
        Teacher teacher7 = new Teacher(7, "jack");

        binaryTree.infixOrder();
        binaryTree.add(teacher1);
        binaryTree.add(teacher2);
        binaryTree.add(teacher3);
        binaryTree.add(teacher4);
        binaryTree.add(teacher5);
        binaryTree.add(teacher6);
        binaryTree.add(teacher7);

        binaryTree.preOrder();
        System.out.println("..................................");
        binaryTree.infixOrder();
        System.out.println("..................................");
        binaryTree.postOrder();

        Teacher t = binaryTree.preSearch(1);
        System.out.println("..................................");
        System.out.println(t);
    }
}

class BinaryTree {
    public Teacher root;

    public void preOrder() {
        if (root == null) {
            System.out.println("tree is empty");
            return;
        }
        root.preOrder();
    }

    public void infixOrder() {
        if (root == null) {
            System.out.println("tree is empty");
            return;
        }
        root.infixOrder();
    }

    public void postOrder() {
        if (root == null) {
            System.out.println("tree is empty");
            return;
        }
        root.postOrder();
    }

    public void add(Teacher teacher) {
        if (root == null) {
            root = teacher;
            return;
        }
        root.add(teacher);
    }

    public Teacher preSearch(int no){
        if (root==null){
            return null;
        }else {
            return root.preSearch(no);
        }
    }

}


class Teacher {
    public int no;
    public String name;
    public Teacher left;
    public Teacher right;

    public Teacher(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void add(Teacher teacher) {
        if (teacher == null) {
            return;
        }
        if (teacher.no < this.no) {
            if (this.left == null) {
                this.left = teacher;
            } else {
                this.left.add(teacher);
            }
        } else {
            if (this.right == null) {
                this.right = teacher;
            } else {
                this.right.add(teacher);
            }
        }
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public Teacher preSearch(int no){
        if (this.no==no){
            return this;
        }
        if (no<this.no){
            if (this.left==null){
                return null;
            }else {
                return this.left.preSearch(no);
            }
        }else {
            if (this.right==null){
                return null;
            }else {
                return this.right.preSearch(no);
            }
        }

    }

    @Override
    public String toString() {
        return "[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ']';
    }
}