package leetcode.easy.RemoveElement.other;

public class Solution {

    /**
     *  maybe you don't need that i
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int n : nums) {
            if (n != val) {
                nums[p++] = n;
            }
        }
        return p;
    }
}
