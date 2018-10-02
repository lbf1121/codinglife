## Week9 Roman to Integer 
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
```text
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.<br>

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
* I can be placed before V (5) and X (10) to make 4 and 9. 
* X can be placed before L (50) and C (100) to make 40 and 90. 
* C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
    
    Example 1:
    Input: "III"
    Output: 3
    
    Example 2:
    Input: "IV"
    Output: 4
    
    Example 3:
    Input: "IX"
    Output: 9
    
    Example 4:
    Input: "LVIII"
    Output: 58
    Explanation: C = 100, L = 50, XXX = 30 and III = 3.
    
    Example 5:
    Input: "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

```Java
public class RomanToInteger {
    
    public int romanToInt(String s) {
        Map<String,Integer> map = initRomanNumeral();
        List<String> romans = initRomanList();
        
        String temp = s;
        int num = 0;
        for(String r : romans){
            int index = temp.indexOf(r);
            while(index>=0){
                num += map.get(r).intValue();
                temp = temp.replaceFirst(r,"");
                index = temp.indexOf(r);
            }
        }
        
        return num;
    }

    /** init roman numeral with map **/
    private Map<String,Integer> initRomanNumeral(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        return map;
    }

    private List<String> initRomanList(){
        List<String> list = new ArrayList<String>();
        list.add("IV");
        list.add("IX");
        list.add("XL");
        list.add("XC");
        list.add("CD");
        list.add("CM");
        list.add("I");
        list.add("V");
        list.add("X");
        list.add("L");
        list.add("C");
        list.add("D");
        list.add("M");
        return list;
    }

    public static void main(String[] args){
        RomanToInteger rt = new RomanToInteger();
        String s = "MCMXCIV";
        s = "III";
        System.out.println(s);
        int n = rt.romanToInt(s);
        System.out.println(" to int :"+n);
    }
}
```
我的思路：把罗马数字的所有组合及对应的数值存放到一个HashMap中，根据字符串匹配，然后把对应的值相加。

#### 以下是讨论区的几种解决思路：
##### solution 1
Idea is simple, we just need to go through all chars/symbols in the string. And Identify which is positive which is negative and sum them up:
* Go from end of the string to the begining char by char
* If current ROMAN present value smaller than whatever appear before, it is a substract/negative, otherwise plus/positive（重点）
```Java
class Solution {
    private static Map<Character, Integer> romanToNumber = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);    
    }}; 
    
    // Go from end of the string to begining
    // If current ROMAN present value smaller than whatever appear before, it is a substract/negative, otherwise plus/positive
    public int romanToInt(String s) {
        int max = 0;
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = romanToNumber.get(s.charAt(i));
            if (cur >= max) {
                max = cur;
                result += cur;
            } else {
                result -= cur;
            }
        }
        
        return result;
    }
}
```
同种思路的另一解法：
```text
 public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum=0;
        for(int i = 0;i < s.length();i++){
            if(i!=s.length()-1 && map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                sum-=map.get(s.charAt(i));
            }else{
                sum+=map.get(s.charAt(i));
            }
        }
        return sum;
    }
```
此种解法最喜欢，也是自己最容易理解的方式
##### solution 2
```Java
class Solution {
    public int romanToInt(String s) {
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }
}
```
##### solution 3
```Java
public class Solution {
    private String[] M = new String[] {"M", "MM", "MMM"};
    private String[] C = new String[] {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private String[] X = new String[] {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private String[] I = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private String[][] map = new String[][] {M, C, X, I}; //Conversion map.
    private int[] scale = new int[]{1000, 100, 10, 1};
    
    public int romanToInt(String s) {
        int ans = 0;;
        for (int k = 0; k < map.length; k++) {
            for (int i = map[k].length - 1; i >= 0; i--) {
                if (s.startsWith(map[k][i])) {
                    ans += (i + 1) * scale[k] ;
                    s = s.substring(map[k][i].length());
                }		
            }
        }
        return ans;
    } 
}
```
此种思路得益于：Input is guaranteed to be within the range from 1 to 3999.
如果没有此条限制，这种罗列就不可取了。