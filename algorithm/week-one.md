Given an array of integers, return indices of the two numbers such that they add up to a specific target.
--------
You may assume that each input would have exactly one solution, and you may not use the same element twice.
--------
Example:
--------
Given nums = [2, 7, 11, 15], target = 9,
--------
Because nums[0] + nums[1] = 2 + 7 = 9,
--------
return [0, 1].
--------

```Java
class TwoSum{
    /*
    开始在leetcode上学习算法，第一道题看似很简单，第一个想法也是简单的进行两次迭代来完成这题。这个思路似乎是自然而然的。没有更多的思考。<br>
    当做完的时候，想了想这个似乎已经成为工作中的定势思维。一点算法的思想都没有。这应该是缺乏算法思维吧。自己也努力的想用其他的更好的更高效
    的办法去解决这个问题，可惜没有成功。只能看看别人的思路学习了。
    
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
    
    /*
    其他解法：
    分析：迭代数组，将数组值做key，index做value存入HashMap,用target-nums[i]到map中寻找差值。减少了一次迭代。
    */
    
    public int[] twoSum(int[] nums, int target) {
         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] defaultResult = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target-nums[i]) != null ) {
                //将两个值的index返回
                int[] result = {map.get(target-nums[i]) + 1, i + 1 };
                return result;
            }
            map.put(nums[i], i);
        }
        return defaultResult;
    }
}
``` 