package com.algorithm.leetcode.easy.ReverseInteger;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 Example 1:
 Input: 123
 Output: 321

 Example 2:
 Input: -123
 Output: -321

 Example 3:
 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2的31次方,  2的31次方 − 1].
 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 public int[] twoSum(int[] nums, int target)
 *
 * @auther liubf
 * @date 2018/8/12
 * @throws
 */
public class ReverseInteger {
    /**
     * leetcode 上比较简短的解决思路
     * 1、先将int值取绝对值
     * 2、将数值转化为字符串，通过StringBuilder的reverse方法反转字符串
     * 3、判断原输入int值符号
     * 4、如果反转后的数值超出了int最大或对小存储范围，会抛出NumberFormatException异常，捕获异常返回0。
     * **/
    public int reverse(int x) {
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
       Leetcode 官方提供解决方案
       将输入int值循环迭代，从个位数开始向最大位数不断取值，并将个位数作为新int值的最高位。
         //pop operation:
         pop = x % 10;
         x /= 10;

         //push operation:
         temp = rev * 10 + pop;
         rev = temp;
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}

/**
 做这道题的时候一直忽略了一个限制条件：Integer.MIN_VALUE 和 Integer.MAX_VALUE，对基本数据类型的概念理解还是不够到位。
 以至于短时间无法完成这道算法。
 刚开始看题觉得非常简单，没想到最终是这样的结果。缜密的逻辑思维，还需要不断加强，还不够细心。
 * **/
