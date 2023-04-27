package com.test;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/3/21
 */
public class TestLambda {

    public static void testFirst() {
        String[] planets = new String[]{"Mercury", "Venus", "Earth"};
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        t.start();
        JOptionPane.showConfirmDialog(null, "Quit?");
        System.exit(0);

    }

    public static void testConstructor() {
        ArrayList<String> names = new ArrayList<>();
        names.add("li");
        names.add("zhang");

        Stream<Person> stream = names.stream().map(Person::new);
        List<Person> pepole = stream.collect(Collectors.toList());
        System.out.println(pepole);

        stream = names.stream().map(Person::new);
        System.out.println(stream.toArray());
    }

    public static void repeatMessage(String text, int delay) {
        ActionListener listener = event -> {
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };

        new Timer(delay, listener).start();
    }

    public static void countDown(int start, int delay) {
        ActionListener listener = event -> {
//            start--;// Error:Can't mutate captured variable
            System.out.println(start);
        };

        new Timer(delay, listener).start();
    }

    public static void repeat(String text, int count) {
        for (int i = 0; i < count; i++) {
            ActionListener listener = event -> {
//                System.out.println(i + ":" + text);// Error:Can't refer to changing;
            };

            new Timer(1000, listener).start();
        }
    }

    public static void testLocalVar() {
        Path first = Paths.get("/usr/bin");
//        Comparator<String> comp = (first, second) -> first.length() - second.length();
        // Error: Variable first already defined
    }

    public void init() {
        ActionListener listener = event -> {
            System.out.println(this.toString());
        };
        new Timer(1000, listener).start();
    }

    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }

    public static void main(String[] args) {

//        testFirst();
//        testConstructor();

//        repeatMessage("hello", 1000);

//        TestLambda testLambda = new TestLambda();
//        testLambda.init();
//        System.out.println("::"+testLambda);

//        repeat(10,()->System.out.println("hello li"));

        repeat(10, i -> System.out.println("Countdown:" + (9 - i)));
    }

    @Override
    public String toString() {
        return "TestLambda{}";
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
