package com.algorithm.algorithm4.test;

import com.algorithm.edu.princeton.cs.algs4.*;

/**
 * 功能说明：
 *
 * @auther liubf
 * @date 2018/12/21
 * @throws
 */
public class FlipsMax {

    public static Counter max(Counter x,Counter y){
        if(x.tally() > y.tally()) return x;
        else return y;
    }

    public static void main(String[] args){
        int T = 100000;
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < T; i++) {
            if(StdRandom.bernoulli(0.5))
                heads.increment();
            else
                tails.increment();
        }

        if(heads.tally() == tails.tally())
            StdOut.println("Tie");
        else
            StdOut.println(max(heads,tails)+" wins");
    }
}
