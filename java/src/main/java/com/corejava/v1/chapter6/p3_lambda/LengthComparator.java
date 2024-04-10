package com.corejava.v1.chapter6.p3_lambda;

import java.util.*;
import java.util.function.BiFunction;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/3/20
 */
public class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        return first.length() - second.length();
    }

    static void testComparator(String[] strings) {
        Comparator<String> comp = (first, second) -> first.length() - second.length();
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, comp);
        System.out.println(Arrays.toString(strings));
    }

    static void testBiFunction(String[] strings) {
        BiFunction<String, String, Integer> comp = (first, second) -> first.length() - second.length();
        System.out.println(Arrays.toString(strings));
        // Arrays.sort方法想要接收一个BiFunction
//        Arrays.sort(strings, comp);
        System.out.println(Arrays.toString(strings));
    }

    static void testPredicate(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if(i % 2 ==0){
                list.add(null);
            }else{
                list.add(String.valueOf(new Random().nextInt(100)));
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
        list.removeIf(e->e ==null);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"ab", "c", "dfs"};
        Arrays.sort(strings, new LengthComparator());
        System.out.println(Arrays.toString(strings));

        System.out.println(".............");
        strings = new String[]{"ab", "c", "dfs"};
        testComparator(strings);

        System.out.println("################");
        testPredicate();
    }
}
