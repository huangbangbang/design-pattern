package com.bj.algorithm;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String string = "BBC ABCDAB ABCDABCDABDE";
        String str = "ABCDABD";
        int[] next = kmpNext(str);
        System.out.println(Arrays.toString(next));
        int i = kmpAlgorithm(string, str,next);
        System.out.println(i);
    }

    private static int kmpAlgorithm(String string, String str, int[] next) {
        for (int i=0,j=0;i<string.length();i++){
            while (j>0&&str.charAt(j)!=string.charAt(i)){
                j=next[j-1];
            }
            if (string.charAt(i)==str.charAt(j)){
                j++;
            }
            if (j==str.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    public static int[] kmpNext(String str){
        int[] next = new int[str.length()];
        next[0]=0;
        for (int i=1,j=0;i<str.length();i++){
            while (j>0&&str.charAt(i)!=str.charAt(j)){
                j=next[j-1];
            }
            if (str.charAt(i)==str.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
