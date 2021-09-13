package com.bj.designpattern;

public class Facade {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.drawCircle();
        System.out.println("==================================================================");
        graph.drawAll();
    }
}

class Graph {
    private Rectangle rectangle= new Rectangle();
    private Circle circle = new Circle();
    private Triangle triangle= new Triangle();

    public void drawRectangle() {

        rectangle.draw();
    }

    public void drawCircle() {

        circle.draw();
    }

    public void drawTriangle() {
        triangle.draw();
    }
    public void drawAll() {
        rectangle.draw();
        circle.draw();
        triangle.draw();
    }
}

class Rectangle {

    public void draw() {
        System.out.println("draw Rectangle");
    }
}

class Circle {
    public void draw() {
        System.out.println("draw Circle");
    }
}

class Triangle {
    public void draw() {
        System.out.println("draw Triangle");
    }
}