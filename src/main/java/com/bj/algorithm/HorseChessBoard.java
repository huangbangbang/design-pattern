package com.bj.algorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessBoard {
    private static boolean[] visited;
    private static boolean finish;
    private static int X ;
    private static int Y;
    private static int num;
    public static void main(String[] args) {
        X=8;
        Y=8;
        int row = 1;
        int column = 1;
        int[][] chessBoard = new int[X][Y];
        visited = new boolean[X*Y];
        long time1 = System.currentTimeMillis();
        traversalChessBoard(chessBoard,row-1,column-1,1);
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        for (int[] link:chessBoard){
            for (int step:link){
                System.out.print(step+"\t");
            }
            System.out.println();
        }
        System.out.println(num);

    }

    private static void traversalChessBoard(int[][] chessBoard, int row, int column, int step) {
        num++;
        chessBoard[row][column] = step;
        visited[row*X+column]=true;
        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);
        while (!ps.isEmpty()){
            Point p = ps.remove(0);
            if (!visited[p.y*X+p.x]){
                traversalChessBoard(chessBoard,p.y,p.x,step+1);
            }
        }
        if (step<X*Y&&!finish){
            chessBoard[row][column]=0;
            visited[row*X+column]=false;
        }
        else {
            finish=true;
        }
    }

    private static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size()-next(o2).size();
                if (count1<0){
                    return -1;
                }else if(count1==0){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }

    private static ArrayList<Point> next(Point point) {
        ArrayList<Point> ps = new ArrayList<>();
        Point p1 = new Point();
        if ((p1.x=point.x-2)>=0&&(p1.y=point.y-1)>=0){
            ps.add(new Point(p1));
        }
        if ((p1.x=point.x-1)>=0&&(p1.y=point.y-2)>=0){
            ps.add(new Point(p1));
        }
        if ((p1.x=point.x+1)<X&&(p1.y=point.y-2)>=0){
            ps.add(new Point(p1));
        }
        if ((p1.x=point.x+2)<X&&(p1.y=point.y-1)>=0){
            ps.add(new Point(p1));
        }
        if ((p1.x=point.x+2)<X&&(p1.y=point.y+1)<Y){
            ps.add(new Point(p1));
        }
        if ((p1.x=point.x+1)<X&&(p1.y=point.y+2)<Y){
            ps.add(new Point(p1));
        }
        if ((p1.x=point.x-1)>=0&&(p1.y=point.y+2)<Y){
            ps.add(new Point(p1));
        }
        if ((p1.x=point.x-2)>=0&&(p1.y=point.y+1)<Y){
            ps.add(new Point(p1));
        }
        return ps;
    }
}
