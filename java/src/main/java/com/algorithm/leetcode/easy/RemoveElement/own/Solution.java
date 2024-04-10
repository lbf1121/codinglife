package com.algorithm.leetcode.easy.RemoveElement.own;

import java.util.Arrays;

public class Solution {

    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length<=0)
            return 0;

        //排序:nums = {1,1,2,2,2,2,3,3,4};
        Arrays.sort(nums);

        int len = nums.length-1;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val && i <= len){
                if((nums[i] != nums[len]) || (i == len)){
                    nums[i] = nums[len];
                    count++;
                }else{
                    count+=2;
                }

                len--;

            }
        }
//        System.out.println(count+" "+len);
//        System.out.println(Arrays.toString(nums));

        int rs = nums.length - count;
        return rs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {1,1,2,2,2,2,3,3,4};//{3,2,2,3};
        int n = s.removeElement(nums,2);
        System.out.println(n);
    }
}
