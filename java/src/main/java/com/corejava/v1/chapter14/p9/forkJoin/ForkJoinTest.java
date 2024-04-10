package com.corejava.v1.chapter14.p9.forkJoin;

import java.util.concurrent.ForkJoinPool;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/4/7
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Math.random();
        }

        Counter counter = new Counter(numbers, 0, numbers.length, x -> x > 0.5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}
