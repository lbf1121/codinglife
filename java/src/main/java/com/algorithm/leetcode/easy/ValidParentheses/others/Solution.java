package com.algorithm.leetcode.easy.ValidParentheses.others;

import java.util.Stack;

public class Solution {

    /**
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (c == ')'){
                if (stack.isEmpty() || stack.pop() != '(')return false;
            }else if (c == ']'){
                if (stack.isEmpty() || stack.pop() != '[')return false;
            }else if (c == '}'){
                if (stack.isEmpty() || stack.pop() != '{')return false;
            }
        }
        return stack.isEmpty();
    }
}
