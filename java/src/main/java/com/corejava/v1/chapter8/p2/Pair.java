package com.corejava.v1.chapter8.p2;

import java.util.function.Supplier;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/4/27
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static <T> Pair<T> makePair(Supplier<T> constr){
        return new Pair<>(constr.get(),constr.get());
    }
}
