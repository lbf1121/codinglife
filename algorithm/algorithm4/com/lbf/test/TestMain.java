package algorithm4.com.lbf.test;

import com.sun.tools.javac.util.StringUtils;

import java.util.*;
import java.util.Stack;

/**
 * 功能说明：
 *
 * @auther liubf
 * @date 2018/12/20
 * @throws
 */
public class TestMain {
    static void testMaxDouble(){
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
    }
    static void testDivide(){
        System.out.println(1.0/0.0);//Infinity 正无穷大
        System.out.println(1/0);    //java.lang.ArithmeticException: / by zero
    }



    static boolean isValid(String s) {
        if(s==null || s.length()<=0){
            return false;
        }

        s = s.replaceAll(" ","");

        Stack<String> stack = new Stack<String>();
        char[] chars = s.toCharArray();
        for (char c:chars) {
            if(!stack.empty() && getOther(c+"")!=null && getOther(c+"").equals(stack.peek())){
                stack.pop();
            }else{
                stack.push(c+"");
            }
        }

        if(stack.empty()){
            return true;
        }

        return false;
    }



    static String getOther(String key){
        Map<String,String> map = new HashMap<String,String>();
        map.put(")","(");
        map.put("]","[");
        map.put("}","{");
        String value = map.get(key);
        return value;
    }

    public static void main(String[] args){

        String s = "()[]{(}[)]";
        System.out.println(isValid(s));
//        System.out.printf("This is PI %.4f ,That is Random Number %.2f.\n",Math.PI,Math.random());
//
//        testMaxDouble();
//
//        testDivide();

//        System.out.println("A".compareTo("a"));
//
//        String a = "234";
//        String b = a;
//        b = "ew";
//
//        System.out.println(a);
//
//        Date date = new Date(12,21,2018);
//        System.out.println(date.toString());
//
//        StringBuilder sb = new StringBuilder("123456");
//        sb.reverse();
//        System.out.println(sb);
//
//        String s = "233";
//        char[] s1 = new char[]{'a','b','c'};
//        s1 = Arrays.copyOf(s1,6);
//        s.getChars(0,s.length(),s1,3);
//        StdOut.print(Arrays.toString(s1));

//        int[] arr = {};
//        System.out.println(arr.length);

//         System.out.println(3+"ab");
//
//
//
//         List<Integer> n = Arrays.asList(new Integer[]{2,3,1,4,7,5,0});
//
//         int a = n.get(0);
//         for (int i = 0; i < n.size(); i++) {
//            if(a<n.get(i)){
//                a = n.get(i);
//            }
//         }
//         System.out.println(a);
    }
}
