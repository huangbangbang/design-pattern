package com.bj.Test;

public class Test23 {
    public static void main(String[] args) {
        String s = "1111111111111";
        int sum=0;
        int j =0;
        for (int i = s.length()-1;i>=0;i--){
            if (s.charAt(i)=='1'){
                sum+=1<<j++;
            }
        }
        System.out.println(sum);
        int a = 013;
        System.out.println(a);
    }
}
