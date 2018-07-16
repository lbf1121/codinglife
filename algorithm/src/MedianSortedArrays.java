package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能说明：
 *
 * @auther liubf
 * @date 2018/7/16
 * @throws
 */
public class MedianSortedArrays {

    static double findMedianSortedArraysz(int[] nums1,int[] nums2){
        double median = 0.0;
        Integer[] arrs = {};
        List<Integer> a = new ArrayList<Integer>();
        a.addAll(Arrays.asList(intArraysToIntegerArrays(nums1)));
        a.addAll(Arrays.asList(intToInteger(nums2)));

        arrs = a.toArray(arrs);
        Arrays.sort(arrs);

        int len = arrs.length;
        if(len%2==0){ //odd number
            int t = arrs.length/2;
            median = (arrs[t-1] + arrs[t] )/2.0;
        }else{//even number
            median = arrs[arrs.length/2] * 1.0;
        }
        return median;
    }

    static Integer[] intToInteger(int[] nums){
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.valueOf(nums[i]);
        }
        return arr;
    }

    static Integer[] intArraysToIntegerArrays(int[] data){
        return Arrays.stream( data ).boxed().toArray( Integer[]::new );
    }

    public static void main(String[] args){
        int[] a = {1};
        int[] b = {3,4};
        double c = findMedianSortedArraysz(a,b);
        System.out.println(c);
    }
}
