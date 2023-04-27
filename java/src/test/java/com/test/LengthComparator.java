package com.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/3/21
 */
public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

    public static void main(String[] args){
        String[] friends = new String[]{"Peters","Paul","Marys"};
        Arrays.sort(friends,new LengthComparator());
        System.out.println(Arrays.toString(friends));
    }
}
