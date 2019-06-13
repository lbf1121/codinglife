package algorithm4.com.lbf.java;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class TwoSumFast {

    /**
     *  Returns the index of the specified key in the specified array.
     * @param key the search key
     * @param a the array of integers ,must be sorted in ascending  order.
     * @return
     */
    static int indexOf(int key,int[] a){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            // 取中间值
            int mid = lo + (hi - lo)/2;
            if     (key < a[mid]) hi = mid - 1;
            else if(key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }
    /**
     * binary search ：折半查找法
     * @param key
     * @param a
     * @return
     */
    static int rank(int key ,int[] a){
        return indexOf(key,a);
    }

    static int count(int[] a){
        // first,sort for binary search
        Arrays.sort(a);

        int count = 0;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            if(rank(-a[i],a)>i)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
}
