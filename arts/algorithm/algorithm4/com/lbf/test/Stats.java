package algorithm4.com.lbf.test;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能说明：常见的背包用例
 *
 * @auther liubf
 * @date 2018/12/22
 * @throws
 */
public class Stats {
    public static void main(String[] args){
        Set<Double> numbers = new HashSet<Double>();
        while(!StdIn.isEmpty()){
            System.out.println(StdIn.readDouble()+" a");
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();
        System.out.println(N+" N");
        double sum = 0.0;
        for(double x : numbers)
            sum += x;
        double mean = sum / N;

        sum = 0.0;
        for(double x : numbers)
            sum += (x - mean) * (x - mean);
        double std = Math.sqrt(sum / (N - 1));

        StdOut.printf("Mean: %.2f\n",mean);
        StdOut.printf("Std dev:%.2f\n",std);


    }
}
