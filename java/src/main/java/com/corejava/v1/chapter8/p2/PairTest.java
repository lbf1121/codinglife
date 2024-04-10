package com.corejava.v1.chapter8.p2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.IntFunction;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/4/27
 */
public class PairTest {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());
        System.out.println('M' + 0);
        System.out.println('m' + 0);
        String middle = ArrayAlg.<String>getMiddle(words);
        System.out.println(middle);

//        double md = ArrayAlg.getMiddle(3.23,4,2);
//        System.out.println(md);
//        JButton jb = ArrayAlg.getMiddle("hello",0,null);

        String min = ArrayAlg.min(words);
        Double[] d = {Double.valueOf(3.4),Double.valueOf(2)};
        Double md = ArrayAlg.min(d);

        Pair<String> mm2 = ArrayAlg.minmaxV2(words);
        System.out.println(mm2.getFirst());
        System.out.println(mm2.getSecond());

        LocalDate[] birthdays = {LocalDate.of(2001,12,4),
                LocalDate.of(1998,5,23),
                LocalDate.of(2023,6,14)};
        Pair<LocalDate> mm3 = ArrayAlg.minmaxV2(birthdays);
        System.out.println(mm3.getFirst());
        System.out.println(mm3.getSecond());

        // getClass方法总是返回原始类型
        System.out.println(mm2.getClass());
        System.out.println(mm3.getClass());

        //不能创建参数化类型的数组,可以声明通配类型的数组，然后进行类型转换
//        Pair<String>[] table = new Pair<String>[10];
        Object[] table2 = new Pair[10];
        table2[0] = new Pair<String>();

        // 可以声明通配类型的数组，然后进行类型转换
        Pair<String>[] table = (Pair<String>[])new Pair<?>[10];
        table[0] = new Pair<String>();
        System.out.println(table[0].getFirst());

        Pair<?>[] table3 = new Pair<?>[10];
        table3[0] = new Pair<LocalDate>();
        System.out.println(table3[0].getFirst());

        Pair<String> pair1 = new Pair<>();
        Pair<String> pair2 = new Pair<>();
        testVaragsMethod(null,pair1,pair2);

        System.out.println("............");
        Pair<String> p = Pair.makePair(String::new);
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());

        List list = new ArrayList<>();

        String[] ss = ArrayAlg.minmax(String[]::new,"Tom","Dick","Harry");
        System.out.println(Arrays.toString(ss));
    }

    static <T> T[] testVaragsMethod(Collection<T> conn, T... st){
        return st;
    }

}

class ArrayAlg {

    public static <T extends Throwable> void doWork(T t) throws T{
        // 编辑时报错：catch子句中不能使用类型变量
//        try{
//
//        }catch(T e){
//            throw e;
//        }

        // 合法
        try{

        }catch(Throwable e){
            t.initCause(e);
            throw t;
        }
    }

    public static <T extends Comparable> T[] minmax(IntFunction<T[]> constr, T... a) {
        T[] mm = constr.apply(2);
//        // 也可以通过反射实现
//        mm = (T[])Array.newInstance(a.getClass().getComponentType(),2);

        if (a == null || a.length == 0) {
            return null;
        }

        mm[0] = a[0];
        mm[1] = a[0];
        for (int i = 0; i < a.length; i++) {
            if (mm[0].compareTo(a[i]) > 0) {
                mm[0] = a[i];
            }
            if (mm[1].compareTo(a[i]) < 0) {
                mm[1] = a[i];
            }
        }
        return mm;
    }

    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        String min = a[0];
        String max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }

    public static <T extends Comparable> Pair<T> minmaxV2(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        T min = a[0];
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    // 对参数T做多个限定时，采用&做分隔符：T extends Comparable&Serializable
    public static <T extends Comparable&Serializable> T min(T[] a){
        if(a==null || a.length==0){
            return null;
        }
        T smallest = a[0];
        for (int i = 0; i < a.length; i++) {
            if(smallest.compareTo(a[i])>0){
                smallest = a[i];
            }
        }
        return smallest;
    }
}
