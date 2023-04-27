package algorithm4.com.lbf.test;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 功能说明：累加器
 *
 * @auther liubf
 * @date 2018/12/21
 * @throws
 */
public class Accumulator {
    private double total;
    private int N;

    public void addDataValue(double val){
        N++;
        total += val;
    }

    public double mean(){
        return total / N;
    }

    public String toString(){
        return "Mean(" + N + " values): " + String.format("%7.5f",mean());
    }

    public static void main(String[] args){
        int T = 1000;
        Accumulator a = new Accumulator();
        for (int i = 0; i < T; i++) {
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }
}

