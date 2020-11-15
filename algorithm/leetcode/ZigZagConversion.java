package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 思路：首先定一个n行的集合，用于分别存放字符串。
 *      当n=2时，两行集合交叉存储字符串中的字符。
 *      当n>2时，首先计算两个完整列之间不完整列的个数为：m = n-2
 *      定义一个开关，0时打印完整列，1时打印不完整列。
 *      当m==(n-1)行存入字符串，其他的行存入空字符串""。
 * @auther liubf
 * @date 2018/7/27
 * @throws
 */
public class ZigZagConversion {
    /**
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }

        //首先定一个n列集合，用于分别存放字符串。
        List[] arr = initListArrays(numRows);

        int interval = numRows-2;//间隔数
        int swich = 0;//开关
        int temp = 0;
        int index = interval;
        for(int i=0;i<s.length();i++){
            if(swich==0){
                arr[temp].add(s.charAt(i)+"");
                temp ++;
                if(temp==numRows){
                    swich = 1;
                    temp = 0;
                }
            }else{
                if(interval>0){
                    for (int j = numRows-1; j >=0; j--) {
                        if(index==j){
                            arr[index].add(s.charAt(i)+"");
                        }else{
                            arr[j].add("");
                        }
                    }

                    index--;

                    if(index==0){
                        swich = 0;
                        index = interval;
                    }
                }else{
                    arr[temp].add(s.charAt(i)+"");
                    temp ++;
                    if(temp==numRows){
                        swich = 0;
                        temp = 0;
                    }
                }
            }

        }

        String result = "";
        for (List l: arr) {
            result += String.join("",l);
        }

        return result;
    }

    private List[] initListArrays(int n){
        List[] l = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            l[i] = new ArrayList();
        }
        return l;
    }

    /**
      Approach 1: Sort by Row
      Intuition
        By iterating through the string from left to right, we can easily determine which row in the Zig-Zag pattern that a character belongs to.
      Algorithm
        We can use min(numRows, len(s)) lists to represent the non-empty rows of the Zig-Zag Pattern.
        Iterate through s from left to right, appending each character to the appropriate row. The appropriate row can be tracked using two variables: the current row and the current direction.
        The current direction changes only when we moved up to the topmost row or moved down to the bottommost row.
    * */
    public String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    /**
     * Approach 2: Visit by Row
     * Intuition
     *  Visit the characters in the same order as reading the Zig-Zag pattern line by line.
     * Algorithm
     *  Visit all characters in row 0 first, then row 1, then row 2, and so on...
     *    Characters in row 0 are located at indexes k(2⋅numRows−2)
     *    Characters in row numRows−1 are located at indexes k(2⋅numRows−2)+numRows−1
     *    Characters in inner row i are located at indexes k(2⋅numRows−2)+i and (k+1)(2⋅numRows−2)−i.
     */
    public String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
    public static void main(String[] args){
        ZigZagConversion zz = new ZigZagConversion();
        String s = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
        //System.out.println(zz.convert(s,2));
    }
}
