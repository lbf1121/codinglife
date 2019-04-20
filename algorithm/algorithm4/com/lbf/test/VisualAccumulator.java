package algorithm4.com.lbf.test;

import algorithm4.com.lbf.java.StdDraw;
import algorithm4.com.lbf.java.StdOut;
import algorithm4.com.lbf.java.StdRandom;

/**
 * 功能说明：
 *
 * @auther liubf
 * @date 2018/12/21
 * @throws
 */
public class VisualAccumulator {
    private double total;
    private int N;

    public VisualAccumulator(int trials,double max){
        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0,max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val){
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N,val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N,total/N);
    }

    public double mean(){
        return total / N;
    }

    public String toString(){
        return "Mean(" + N + " values): " + String.format("%7.5f",mean());
    }

    public static void main(String[] args){
        int T = 1000;
        VisualAccumulator va = new VisualAccumulator(T,1.0);
        for (int i = 0; i < T; i++) {
            va.addDataValue(StdRandom.random());
        }
        StdOut.println(va);
    }
}
