# 21. Remove Duplicates From Sorted Array
* [Description](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

### official
* [Solution](./easy/RemoveDuplicatesFromSortedArray/others/Solution.java)

### others
* [Solution](./easy/RemoveDuplicatesFromSortedArray/others/Solution.java)

### own 
* [Solution](easy/RemoveDuplicatesFromSortedArray/own/Solution.java)
* success

#### 解题思路：
数组：int nums = [1,1,2,2,3,3,4,4,5]
* 1.将所有重复的值，是用nums[0]-1（nums[0]-1>=Integer.MIN_VALUE）替换,因为数组有序，所以nums[0]-1不会是数组中存在的值。
    * 例如：nums替换后为：[1,0,2,0,3,0,4,0,5],并计算替换次数n,最终返回长度为nums.length-n
* 2.将数组nums中的值nums[0]-1，使用其后面非nums[0]-1依次替换
    * [1,0,2,0,3,0,4,0,5] 中nums[2]之后所有元素前移一位为：[1,2,0,3,0,4,0,5,5]，依此类推，最终为：[1,2,3,4,5,5,5,5,5]
    
