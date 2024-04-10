package com.corejava.v1.chapter9.p1;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/5/10
 */
public class QueueTest {

    public static void main(String[] args){
        ArrayQueue arrayQueue = new ArrayQueue<>(5);
        arrayQueue.add("a");

        LinkedList linkedList = new LinkedList();

//        int len = 10;
//        int n = 5;
//        for (int i = 1; i <= len; i++) {
//            System.out.println((i+" % "+n+" = ")+(i % n));
//        }

        System.out.println("========右移运算符====");
        // 右移运算符
        for (int i = 0; i < 10; i++) {
            System.out.print((i+" >> 1 = ")+(i >> 1)+", ");
            System.out.println((i+" / 2 = ")+(i / 2));
        }
        System.out.println("========左移运算符====");
        // 左移运算符
        for (int i = 0; i < 10; i++) {
            System.out.print((i+" << 1 = ")+(i << 1)+", ");
            System.out.println((i+" * 2 = ")+(i * 2));
        }
    }
}
