Week One
========
Tow Sum
-----
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.<br>
Example:<br>
Given nums = [2, 7, 11, 15], target = 9,<br>
Because nums[0] + nums[1] = 2 + 7 = 9,<br>
return [0, 1].<br>

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
解决方案
------
```
方法一：暴力法
暴力法很简单。遍历每个元素 xx，并查找是否存在一个值与 target - xtarget−x 相等的目标元素。
'''Java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
''''

方法二：两遍哈希表
'''Java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
'''
方法三：一遍哈希表
'''Java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
```