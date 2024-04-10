package com.algorithm.leetcode.easy.Implement_strStr.own;

public class Solution {

    public static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr(String haystack, String needle) {
        if("".equals(haystack) && "".equals(needle)) return 0;
        if("".equals(haystack) && !"".equals(needle)) return -1;
        if("".equals(needle)) return 0;

        int index = -1;
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        if(needleChars.length>haystackChars.length){
            return index;
        }

        int n = 0;
        //验证是否是子字符串
        index = getFirstIndex(haystackChars,needleChars[0],needleChars.length,n);
        while(index>-1){
            if(checkSubStr(haystackChars,needleChars,index)){
                break;
            }

            n = index+1;
            if(n<haystackChars.length){
                index = getFirstIndex(haystackChars,needleChars[0],needleChars.length,n);
            }
        }

        return index;
    }

    public static boolean checkSubStr(char[]haystackChars,char[]needleChars,int index){
        boolean f = true;
        for (int i = 0; i < needleChars.length; i++) {
            if (haystackChars[i+index] != needleChars[i]) {
                f = false ;
                break;
            }
        }
        return f;
    }

    public static int getFirstIndex(char[] haystackChars,char c,int subCharLen,int n){
        for (int i = n; i < haystackChars.length; i++) {
            if(c == haystackChars[i] && i <= (haystackChars.length-subCharLen)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaaa";

        System.out.println(strStr(a,b));
        System.out.println("".toCharArray());
    }
}
