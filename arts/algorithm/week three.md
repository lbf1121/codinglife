给定一个字符串，找出不含有重复字符的最长子串的长度。
示例：
给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
```
class Solution {
    static int lengthOfLongestSubstring(String s){
        if(s!=null && s.length()>0){
            int len = 0;
            for(int i=0;i<s.length();i++){
                for(int j=s.length();j>i;j--){
                    String tempB = s.substring(i,j);
                    if(tempB.length()<len){
                       break;
                    }
                    int count = 0;
                    char[] c = tempB.toCharArray();
                    for(int k=0;k<c.length;k++){
                        char cc = c[k];
                        if(tempB.indexOf(cc)!=tempB.lastIndexOf(cc)){
                            count++;
                            break;
                        }
                    }

                    if(count==0){
                        len = tempB.length();
                        break;
                    }
                }
            }

            return len;

        }
        return 0;
    }
}
* it is correct,but not efficient enough
勉强把这个算法的功能，简单粗暴的实现。但是效率很低，执行结果：
Submission Result: Time Limit Exceeded。
学习算法这个事情，可能需要调整下方式。不能光靠这种if else + for 来应对所有的算法。这样的算法也不能称之为算法。
我需要调整自己方式方法。想法：规定1小时时间内，如果无法完成算法，就直接学习他人解法，记住解题思路。
再以自己理解的方式，重新完成算法。当作数学公式来学习。

```
[LeetCode Approach](https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/)

