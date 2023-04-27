package algorithm4.com.lbf.test;

import java.util.Arrays;

/**
 * 功能说明：
 *
 * @auther liubf
 * @date 2018/12/22
 * @throws
 */
public class StaticSETofInts {

    private int[] a;

    public StaticSETofInts(int[] keys){
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i]; //保护性复制
        }
        Arrays.sort(a);
    }

    public boolean contains(int key){
        return rank(key) != -1;
    }

    private int rank(int key){
        //二分查找
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            //key 要么存在与a[lo..hi]中，要么不存在
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]) hi = mid - 1;
            else if(key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
