public class TwoSum{
    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length-1;i++){
            int a = nums[i];
            for(int j=i+1;j<nums.length;j++){
                int b = nums[j];
                int c = a+b;
                if(c==target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] a =
    }
}