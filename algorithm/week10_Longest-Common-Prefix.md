## Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

    Input: ["flower","flow","flight"]
    Output: "fl"
    Example 2:
    
    Input: ["dog","racecar","car"]
    Output: ""
Explanation: There is no common prefix among the input strings.
* Note:All given inputs are in lowercase letters a-z.

### My Sulotion:
```java
class Solution {
        public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        //1.find the shortest child in String[]
        String shortStr = shortestStr(strs);
        String r = "";
        for (int i = 0; i < shortStr.length(); i++) {
            String s = shortStr.substring(0,i+1);
            String s1 = getLongestStr(strs,s,i+1);
            if(s1!=""){
                r = s1;
            }else{
                return r;
            }
        }
       return r;
    }
    
    /**
     * 找到最短字符串与其他子字符串的longest common prefix string
     */
    private String getLongestStr(String[] strs,String s,int index){
        //System.out.println(s +"======="+index);
        for (String item: strs) {
            if(!s.equals(item.substring(0,index))){
                return "";
            }
        }
        return s;
    }

    private String shortestStr(String[] strs){
        int len = strs[0].length();
        String r = "";
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            if(s.length()<=len){
                len = s.length();
                r = s;
            }
        }
        //System.out.println("==short==="+r);
        return r;
    }
}
```
### Solution
#### Approach 1: Horizontal scanning
Intuition

For a start we will describe a simple way of finding the longest prefix shared by a set of strings LCP(S<sub>1</sub>...S<sub>n</sub>)
. We will use the observation that :

LCP(S<sub>1</sub>...S<sub>n</sub>) = LCP(LCP(LCP(S<sub>1</sub>,S<sub>2</sub>),S<sub>3</sub>),S<sub>n</sub>)

Algorithm

To employ this idea, the algorithm iterates through the strings [S<sub>1</sub>....S<sub>n</sub>], finding at each iteration ii the longest common prefix of strings LCP(S<sub>1</sub>...S<sub>i</sub>) When LCP(S<sub>1</sub>...S<sub>i</sub>) is an empty string, 
the algorithm ends. Otherwise after nn iterations, the algorithm returns LCP(S<sub>1</sub>....S<sub>n</sub>).
![imge](https://leetcode.com/media/original_images/14_basic.png)
Figure 1. Finding the longest common prefix (Horizontal scanning)
```java
 public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }        
    return prefix;
}
```
#### Complexity Analysis
* Time complexity : O(S)O(S) , where S is the sum of all characters in all strings.In the worst case all nn strings are the same. The algorithm compares the string S1 with the other strings [S<sub>2</sub>....S<sub>n</sub>] There are SS character comparisons, where S is the sum of all characters in the input array.
* Space complexity : O(1)O(1). We only used constant extra space.

#### Approach 2: Vertical scanning
Algorithm

Imagine a very short string is at the end of the array. The above approach will still do S comparisons. One way to optimize this case is to do vertical scanning. We compare characters from top to bottom on the same column (same character index of the strings) before moving on to the next column
```java
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);             
        }
    }
    return strs[0];
}
``` 
#### Complexity Analysis
* Time complexity : O(S) , where S is the sum of all characters in all strings. In the worst case there will be nn equal strings with length mm and the algorithm performs S = m*n character comparisons. Even though the worst case is still the same as Approach 1, in the best case there are at most n*minLen comparisons where minLen is the length of the shortest string in the array.
* Space complexity : O(1). We only used constant extra space. 

[官方解](https://leetcode.com/problems/longest-common-prefix)