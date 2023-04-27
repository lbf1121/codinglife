package com.test;

import java.util.Arrays;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/3/21
 */
public class TestCompareClone implements Cloneable,Comparable<TestCompareClone>{
    private Integer age;

    public TestCompareClone(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(TestCompareClone o) {
        return Integer.compare(age,o.age);
    }

    @Override
    public String toString() {
        return "TestCompareClone{" +
                "age=" + age +
                '}';
    }

    public static void main(String[] args){
        TestCompareClone[] arr = new TestCompareClone[3];
        TestCompareClone a = new TestCompareClone(23);
        TestCompareClone b = new TestCompareClone(20);
        TestCompareClone c = new TestCompareClone(25);
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        try {
            TestCompareClone d = c;
            System.out.println(c.hashCode());
            System.out.println(d.hashCode());
            TestCompareClone e = (TestCompareClone)c.clone();
            System.out.println(e.hashCode());

            System.out.println(e instanceof TestCompareClone);
            System.out.println(e instanceof Comparable);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
