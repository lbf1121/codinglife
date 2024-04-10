package com.corejava.v1.chapter6.p5_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/4/19
 */
public class ProxyTest {
    public static void main(String[] args){
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length)+1;
        int result = Arrays.binarySearch(elements,key);
        if(result>=0){
            System.out.println(elements[result]);
        }
    }
}
