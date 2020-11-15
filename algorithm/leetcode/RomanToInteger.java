package leetcode;

import java.util.*;

public class RomanToInteger {
    //Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
    public int romanToInt(String s) {
        Map<String,Integer> map = initRomanNumeral();
        int num = 0;

        List<String> romans = initRomanList();
        String temp = s;
        for(String r : romans){
            int index = temp.indexOf(r);
            while(index>=0){
                num += map.get(r).intValue();
                temp = temp.replaceFirst(r,"");
                index = temp.indexOf(r);
            }
        }
        if(num<1 || num >3999){
            return 0;
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
