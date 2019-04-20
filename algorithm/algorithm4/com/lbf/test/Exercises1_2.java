package algorithm4.com.lbf.test;

import algorithm4.com.lbf.java.StdOut;

/**
 * 功能说明：1.2 练习
 *
 * @auther liubf
 * @date 2018/12/22
 * @throws
 */
public class Exercises1_2 {
    static void test4(){
        String s1 = "hello";
        String s2 = s1;
        s1 = "world";

        System.out.println(s1);
        System.out.println(s2);
    }

    static  void test5(){
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6,11);
        System.out.println(s);
    }

    /**
     * 练习：1.2.7
     * 答案：字符串反转
     * **/
    static String mystery(String s){
        int N = s.length();
        if(N <= 1) return s;
        String a = s.substring(0,N/2);
        String b = s.substring(N/2,N);
        return mystery(b) + mystery(a);
    }
    public static void main(String[] args){
        test4();

        test5();

        StdOut.print(mystery("abcde"));
    }
}
