package com.test;

/**
 * final类不能被继承
 *
 * @auther liubf
 * @date 2023/3/13
 */
public class TestA {

    private final String name;

    public TestA() {
        this.name = "默认";
    }

    public TestA(String name) {
        this.name = name;
    }

    public final void testFial(){
        System.out.println("我是testFial");
    }

    public String getName(){
        return this.name;
    }

    public static void main(String[] args){
        TestB testB = new TestB();
        testB.testFial();
        System.out.println(testB);
    }
}

class TestB extends TestA{
    public TestB() {
    }
    public TestB(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "TestB{name="+getName()+"}";
    }
}
