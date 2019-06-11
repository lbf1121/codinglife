package algorithm4.com.lbf.test;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

/**
 * 功能说明：1.1 练习
 *
 * @auther liubf
 * @date 2018/12/20
 * @throws
 */
public class Exercises1_1 {

    static void test1(){//1.1.1
        System.out.println((0+15)/2);  //7
        System.out.println(2.0e-6 * 100000000.1);   //2.0e-6 * 100000000.1 = 2.0e-6 * 1.000000001e8 = 2.000000002e2 = 200.0000002
        System.out.println(true && false || true && true);  //true
    }
    static void test2(){//1.1.2
        System.out.println((1 + 2.236) / 2);    //1.618
        System.out.println(1+2+3+4.0);  //10.0
        System.out.println(4.1>=4);     //true
        System.out.println(1+2+"3");    //"33"
    }

    static void test3(int a,int b,int c){
        if(a == b && b==c)
            System.out.println("equal");
        else
            System.out.println("not equal");
    }

    static void test4(){
        int a = 1,b = 2,c = 0;
        //if(a > b) then c = 0;   //then 不是java关键字，应该去掉then或将其改为else
        //if a > b { c = 0;}  // a > b 应放入()内
        if(a > b) c = 0;   //正确
        //if(a > b) c = 0 else b = 0;  // c = 0 后面缺少截止符号;
    }

    static void test5(double x,double y){
        if((x > 0 && x <1 ) && (y > 0 && y <1 ))
            System.out.println(true);
        else
            System.out.println(false);
    }

    static void test6(){
        int f = 0;
        int g = 1;
        for (int i = 0; i <=15 ; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    static void test7(){
        double t = 9.0;
        while(Math.abs(t - 9.0/t) > .001){
            t = (9.0/t + t) / 2.0;
        }
        StdOut.printf("%.5f\n",t);

        int sum = 0;
        for(int i = 1;i < 1000;i++){
            for (int j = 0; j < i; j++) {
                sum ++;
            }
        }
        StdOut.println(sum);//1..9999 相加

        int sum2 = 0;
        for (int i = 1; i < 1000; i*=2) {
            for (int j = 0; j < 1000; j++) {
                sum2++;
            }
        }
        StdOut.println(sum2);//10 个 1000相加
    }

    static void test8(){
        //A -- 65  a--97
        System.out.println((char)('A'+32));

        System.out.println((int)'b');
        System.out.println((int)'B');
        System.out.println('b');//b
        System.out.println('b'+'c');//197
        System.out.println((char)('b'+4));//f
    }

    /** 将一个整数n转换为二进制形式的字符串 **/
    static void test9(){

        //短除求余，字符串反转
        int n = 19;
        String s = "";
        while (n>0){
            s = n % 2 + s;
            n = n / 2;
        }
        System.out.println(s);

        //Java API
        n = 21;
        String s2 = Integer.toBinaryString(n);
        System.out.println(s2);


        String s3 = "";
        n = 17;
        for (int i = n; i > 0; i /= 2 ) {
            s3 = (i % 2) + s3;
        }
        System.out.println(s3);
    }

    static void test10(){
//        int[] a;
//        for (int i = 0; i < 10; i++) {
//            a[i] = i*i;
//        }
        //产生：variable a might not have been initialized 的编译错误
    }

    static void test11(){
        //初始化二维boolean数组
        boolean[][] b = new boolean[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                int n = new Random().nextInt(100);
                b[i][j] = n > 50 ? true : false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (b[i][j] ) System.out.println("row:"+i+",column:"+j+",is *");
                else System.out.println("row:"+i+",column:"+j+",is  ");
            }
        }

        System.out.println(Arrays.deepToString(b));
    }

    static void test12(){

        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < 10; i++)
            System.out.println(i);

    }

    static void test13(int n){
        //M行N列二维数组的转置（交换行和列）

    }
    static void test14(){
        //求log2N的最大整数

    }
    static void test15(){
        //
    }

    //test16 结果并非整数相加，而是整数有拼接而成的字符串
    static String exR1(int n){
        if(n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    static String exR1_2(int n){
        if(n <= 0) return "";
        return exR1_2(n - 3) +(n + n)+ exR1_2(n - 2);
    }

    //test17 此函数调用后将进行无限循环，直至StackOverflowError
    static String exR2(int n){

        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if(n <= 0) return "";
        return s;
    }

    //test18
    static int mystery(int a,int b){
        if(b==0) return 0;
        if(b % 2 ==0) return mystery(a+a,b/2);
        return mystery(a+a,b/2)+2;
    }

    static int mystery2(int a,int b){
        if(b==0) return 1;
        if(b % 2 ==0) return mystery2(a*a,b/2);
        return mystery2(a*a,b/2)+2;
    }

    //test19
    static long F(int N){
        if(N == 0) return 0;
        if(N == 1) return 1;
        return F(N - 1) + F(N -2);
    }

    //test20
    static long factorial(int n){
        if(n<=0) return 1;   //防止内存溢出
        return n * factorial(n-1);
    }

    static double ln(int n){
        long f = factorial(n);
        System.out.println(f);
        return Math.log(f);
    }

    public static void main(String[] args){

//        test1();
//
//        test2();
//
//        if(args!=null && args.length==3){
//            int a = Integer.parseInt(args[0]);
//            int b = Integer.parseInt(args[1]);
//            int c = Integer.parseInt(args[2]);
//            test3(a,b,c);
//        }
//
//        test5(0.1,0.3);
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
//        test11();
//        test12();

//        System.out.println(exR1(6));//311361142246
//        System.out.println(""+3+2+"");
//        System.out.println(exR1_2(6));//6212284

//        int a = mystery(2,25);//4
//        int b = mystery(3,11);//6
//        int c = mystery2(2,25);//4
//        int d = mystery2(3,11);//6
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//
//        //整除舍弃小数部分，只看整数部分
//        System.out.println(1/2);//0
//        //求余的模运算%，奇数为1，偶数为0
//        System.out.println(0%2);//0
//        System.out.println(1%2);//1
//        System.out.println(2%2);//0

//        long[] l = new long[100];
//        l[0] = 0;
//        l[1] = 1;
//        for (int i = 2; i < 100; i++) {
//            //StdOut.println(i+" "+F(i));
//            l[i] = l[i-1] + l[i-2];
//        }
//        System.out.println(Arrays.toString(l));

        System.out.println(ln(5));
    }
}
