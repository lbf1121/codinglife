package leetcode;


/**
 * 功能说明：Given a string s, find the longest palindromic substring in s.You may assume that the maximum length of s is 1000.
 * 找出一个字符串中最长的回文子字符串。
 *Example 1:
 *Input: "babad"
 *Output: "bab"
 *Note: "aba" is also a valid answer.
 *Example 2:
 *Input: "cbbd"
 *Output: "bb"
 * 思路：
 *    情景1：这个回文字符串无中心字符串：acca
 *    假定n，n+1 相等，然后以n和n+1为中心，查询比较 n-- 是否与 ++(n+1) 相等，如果相等则继续查询比较。
 *    得到substring(min(--n),max(++(n+1)))
 *    情景2：这个回文字符串有中心字符串：acdca
 *    假定每一个字符都是中心的字符串n，然后以n为中心，查询比较--n 是否 与 ++n 相等，如果相等则继续查找比较。
 *    得到substring(min(--n),max(++n))。
 *    最后将两种情况中最长的字符串返回。
 * @auther liubf
 * @date 2018/7/22
 * @throws
 */
public class LongestPalindromicSubstring {
    /*
    * 解题思路是对的，但是无法短时间实现。最终还是借鉴，Solution
    * */
    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = findSubLength(s,i,i);
            int len2 = findSubLength(s,i,i+1);
            int tempMax = Math.max(len1,len2);
            if(tempMax>(end-start)){
                start = i-(tempMax-1)/2;
                end = i+tempMax/2;
            }
        }
        return s.substring(start, end+1);
    }

    private int findSubLength(String s,int start,int end){
        int min = start;
        int max = end;
        while(min>=0 && max<s.length() && s.charAt(min)==s.charAt(max)){
            --min;
            ++max;
        }
        return max-min-1;
    }


    public static void main(String[] args){
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        String s = "caba";
        String rs = l.longestPalindrome(s);
        System.out.println(rs);
    }
}
