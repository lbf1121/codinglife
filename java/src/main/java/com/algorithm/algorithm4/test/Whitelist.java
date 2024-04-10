package com.algorithm.algorithm4.test;

import com.algorithm.edu.princeton.cs.algs4.*;

/**
 * 功能说明：
 *
 * @auther liubf
 * @date 2018/12/22
 * @throws
 */
public class Whitelist {
    public static void main(String[] args){
        int[] w = new int[]{12,3,4,45,32,16,7,8,97};
        StaticSETofInts set = new StaticSETofInts(w);
        while(!StdIn.isEmpty()){
            //读取key如果不在白名单中则打印它
            int key = StdIn.readInt();
            if(!set.contains(key))
                StdOut.print(key);
            else
                StdOut.print("contains...");
        }
    }
}
