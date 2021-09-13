package com.bj.algorithm;

public class ViolenceMatch {
    public static void main(String[] args) {
        String string = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str = "尚硅谷你尚硅你";

        int i = violenceMatch(string, str);
        System.out.println(i);
    }

    private static int violenceMatch(String string, String str) {
        int j = 0;
        int i = 0;
        while (i<string.length()) {
            if (string.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j+1;
                j = 0;
            }
            if (j == str.length()) {
                return i-j;
            }
        }
        return -1;
    }
}
