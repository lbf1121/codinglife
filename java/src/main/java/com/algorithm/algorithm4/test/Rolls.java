package com.algorithm.algorithm4.test;

import com.algorithm.edu.princeton.cs.algs4.*;

import java.util.Random;

/**
 * 功能说明：模拟T次掷骰子的Counter对象的用例
 *
 * @auther liubf
 * @date 2018/12/21
 * @throws
 */
public class Rolls {

    private static Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed

    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    static int uniform(int n){
        if(n <= 0)
            throw new IllegalArgumentException("argument must be positive: " + n);

        return random.nextInt(n);
    }

    static int uniform(int a,int b){
        if ((b <= a) || ((long) b - a >= Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("invalid range: [" + a + ", " + b + ")");
        }
        return a + uniform(b-a);
    }

    public static void main(String[] args){
        int T = 10;

        //初始化一个骰子的六个面：1～6
        int SIDES = 6;
        Counter[] rolls = new Counter[SIDES+1];
        for (int i = 1; i <= SIDES; i++) {
            rolls[i] = new Counter(i+"'s");
        }

        //投掷次数
        for (int i = 0; i < T; i++) {
            //取[1-7)的随机数
            int result = uniform(1,SIDES+1);
            rolls[result].increment();
        }

        for (int i = 1; i <= SIDES; i++) {
            StdOut.println(rolls[i]);
        }
    }
}
