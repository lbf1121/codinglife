package com.corejava.v1.chapter6.p3_lambda;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/3/20
 */
public class LambdaTest {
    public static void main(String[] args){
        String[] planets = new String[]{"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted by length:");
        Arrays.sort(planets,(first,second)->first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        System.out.println("compareToIgnoreCase:字典排序");
        Arrays.sort(planets,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(planets));

//        Timer t = new Timer(1000,new Worker());
//        Timer t = new Timer(1000,event->System.out.println("The time is "+new Date()));
        Timer t = new Timer(1000,System.out::println);
        t.start();

        // 不能直接new 需要将TimedGreeter、Greeter改为static的才可以
        TimedGreeter tg = new TimedGreeter();
        tg.greet(null);

        // Object不是一个函数式接口，因此不能被赋值lambda表达式
//        Object obj = (String first,String second)->first.length() - second.length();
        Comparator<String> comp = (first,second)->first.length() - second.length();

        List<String> names = new ArrayList<>();
        names.add("zhang");
        names.add("li");
// 静态方法中使用::时，类需是静态类
//        Stream<Person> stream = names.stream().map(name->new Person(name));
        Stream<Person> stream = names.stream().map(Person::new);
        List<Person> plist = stream.collect(Collectors.toList());
        System.out.println(plist);

        LambdaTest test = new LambdaTest();
        test.testPerson();

        Arrays.sort(plist.toArray(new Person[plist.size()]),Comparator.comparing(Person::getName,Comparator.nullsFirst(Comparator.naturalOrder())));

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    void testPerson(){
        // 成员方法中使用::时，类可为非静态类或静态类
        List<String> names = new ArrayList<>();
        names.add("zhang2");
        names.add("li2");
        Stream<Person1> stream = names.stream().map(Person1::new);
        List<Person1> plist = stream.collect(Collectors.toList());
        System.out.println(plist);

        Stream<Person> stream2 = names.stream().map(Person::new);
        List<Person> plist2 = stream2.collect(Collectors.toList());
        System.out.println(plist2);
    }

    class Person1{
        String name;

        public Person1() {
        }

        public Person1(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person1{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class Person{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Person() {
        }

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

    static class Greeter{
        public void greet(ActionEvent actionEvent){
            System.out.println("Hello!");
        }
    }

    static class TimedGreeter extends Greeter{
        @Override
        public void greet(ActionEvent actionEvent){
            Timer t = new Timer(1000,super::greet);
            t.start();
        }
    }
}
