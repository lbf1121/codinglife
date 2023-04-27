package com.test;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.IntHolder;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/3/16
 */
public class TestWrapper extends TestBase implements ITestBase,ITestWrapper{

    private String name;

    public TestWrapper(){}

    public TestWrapper(String name){
        this.name = name;
    }

    @Override
    public String test() {
        return null;
    }

//    @Override
//    public void unzip() {
//        System.out.println("my unzip");
//    }

    public static void main(String[] args) {
//        int x = 2;
//        triple(x);
//        System.out.println(x);
//
//        Integer xx = 3;
//        triple(xx);
//        System.out.println(xx);
//
//        IntHolder xxx = new IntHolder();
//        xxx.value = 4;
//        triple(xxx);
//        System.out.println(xxx.value);

//        variableParameter(new int[]{2,3,4});

        System.out.println(int.class);

        TestWrapper t = new TestWrapper();
        t.unzip();
    }

    public static void triple(int x) {
        x = 3 * x;
    }

    public static void triple(Integer x) {
        x = 3 * x;
    }

    public static void triple(IntHolder x) {
        x.value = 3 * x.value;
    }

    public static void variableParameter(Object... objs) {
        for (Object obj : objs) {
            if(obj instanceof int[]){
                int[] arr = (int[])obj;
                System.out.println(arr.getClass());
                for (int a : arr){
                    System.out.println("int[]:"+a);
                }
            }
        }
    }
}
