package com.corejava.v1.chapter9.p1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/6/25
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("user_" + (i + 1));
        }

        Iterator<String> it = list.iterator();
        it.next();
        it.remove();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
            if (s.contains("6")) {
                it.remove();
            }
        }

        System.out.println("===============");
        it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("===============");
        for (String s : list) {
            if (s.equals("user_2")) {
                list.remove(s);
//                break;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
