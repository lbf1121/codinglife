package com.corejava.v1.chapter9.p2;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/3/29
 */
public class PriorityQueueTest {

    public static void main(String[] args){
        PriorityQueue<LocalDate> queue = new PriorityQueue<>();
        queue.add(LocalDate.of(1906,12,9));
        queue.add(LocalDate.of(1815,12,10));
        queue.add(LocalDate.of(1903,12,3));
        queue.add(LocalDate.of(1910,6,22));

        System.out.println("Iterating over elements...");
        for (LocalDate localDate : queue) {
            System.out.println(localDate);
        }
        System.out.println("Removing elements...");
        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }
}
