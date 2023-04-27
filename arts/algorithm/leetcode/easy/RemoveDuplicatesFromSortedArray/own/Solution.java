package leetcode.easy.RemoveDuplicatesFromSortedArray.own;

import java.util.Arrays;

public class Solution {

    public static int removeDuplicates(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int tem = nums[0];
        for(int i=1;i<nums.length;i++){
            if(tem == nums[i]){
                tem = nums[i];
                nums[i] = nums[0]-1;
            }else{
                tem = nums[i];
            }
        }

        int len = nums.length;
        for(int i=1;i<len;){
            if(nums[i]==nums[0]-1){
                for(int j=i;j<len-1;j++){
                    nums[j] = nums[j+1];

                }
                len--;
            }
            if(nums[i]!=nums[0]-1){
                i++;
            }
        }
        return len;
    }

    public static int removeDuplicates2(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int len = nums.length;
        int tem = nums[0];
        for(int i=1;i<len;){
            if(nums[i]==tem){
                for(int j=i;j<len-1;j++){
                    nums[j] = nums[j+1];

                }
                len--;

                tem = nums[i];
            }else{
                tem = nums[i];
                i++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] n = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates2(n);
        System.out.println(len);

        for (int i = 0; i < len; i++) {
            System.out.println(n[i]);
        }

    }
}
