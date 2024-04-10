package com.algorithm.algorithm4.test;

/**
 * 功能说明：
 *
 * @auther liubf
 * @date 2018/12/21
 * @throws
 */
public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int m,int d,int y){
        this.month = m;
        this.day = d;
        this.year = y;
    }

    public int month(){
        return month;
    }
    public int day(){
        return day;
    }
    public int year(){
        return year;
    }
    public String toString(){
        return month()+"/"+day()+"/"+year();
    }
}

/** 使用的变量更少，更节省空间 ：目前还不理解其能正确实现的原理是什么。**/
class Date2{
    private final int value;
    public Date2(int m,int d,int y){
        value = y * 512 + m * 32 + d;
    }

    public int month(){
        return (value / 32) % 16;
    }
    public int day(){
        return value % 32;
    }
    public int year(){
        return value / 512;
    }
    public String toString(){
        return month()+"/"+day()+"/"+year();
    }
}
