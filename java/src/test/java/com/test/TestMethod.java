package com.test;

import java.lang.reflect.Method;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/3/16
 */
public class TestMethod {
    public static void main(String[] args) {
        try {
            Method square = TestMethod.class.getDeclaredMethod("square", double.class);
            Method sqrt = Math.class.getDeclaredMethod("sqrt", double.class);
            printTable(1, 10, 10, square);
            printTable(1, 10, 10, sqrt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double square(double x) {
        return x * x;
    }

    private static void printTable(double from, double to, int n, Method f) {
        System.out.println(f);
        double dx = (to - from) / (n - 1);
        for (double x = from; x <= to; x += dx) {
            try {
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
