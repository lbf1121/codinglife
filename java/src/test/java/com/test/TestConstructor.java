package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/3/16
 */
public class TestConstructor {
    private String name;
    private Integer age;

    public TestConstructor(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args){
        try{
            // 使用Constructor构造函数对象，创建并初始化一个Constructor代表的类的实例对象
            Constructor<TestConstructor> c = TestConstructor.class.getDeclaredConstructor(new Class[]{String.class,Integer.class});
            TestConstructor tc = c.newInstance("lili",23);
            System.out.println(tc.getName());

            // 构造函数参数的数据类型
            Class<?>[] ptypes = c.getParameterTypes();
            for (Class<?> pt : ptypes){
                System.out.println(pt.getName());
            }

            Type[] types = c.getGenericParameterTypes();
            for (Type t : types){
                System.out.println(t);
            }

            // tc对象私有属性是否可以访问
            System.out.println(c.isAccessible());
            // 判断当前构造函数是否是一个复合构造方法，如果是返回true,否则返回false
            System.out.println(c.isSynthetic());
            // 判断当前构造函数是否采用可变参数，如果是返回true,否则返回false
            System.out.println(c.isVarArgs());
            // 判断注解@Deprecated是在TestConstructor类上
            System.out.println(c.isAnnotationPresent(Deprecated.class));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
