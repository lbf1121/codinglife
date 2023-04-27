package leetcode.easy.ValidParentheses.own;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 根据official solution 解决
 */
public class Solution {

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
    }
}
