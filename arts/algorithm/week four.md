There are two sorted arrays nums1 and nums2 of size m and n respectively.<br>
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).<br>
Example 1:
```
nums1 = [1, 3]
nums2 = [2]
The median is 2.0
```
Example 2:
```
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```
```Java
   public class MedianSortedArrays {
   
    public double findMedianSortedArraysz(int[] nums1,int[] nums2){
        double median = 0.0;
        Integer[] arrs = {};
        List<Integer> a = new ArrayList<Integer>();
        a.addAll(Arrays.asList(intArraysToIntegerArrays(nums1)));
        a.addAll(Arrays.asList(intArraysToIntegerArrays(nums2)));

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


    public Integer[] intArraysToIntegerArrays(int[] data){
        return Arrays.stream( data ).boxed().toArray( Integer[]::new );
    }
   }
```
总结：虽然解决了问题，但感觉不是自己在做算法题，似乎是在使用java的api。是不是算法题不适合使用java来做。
     还是说使用java的方式方法不对，我是不是应该学习C然后用c来学习做算法，才能真正的掌握算法知识。

[LeetCode Approach](https://leetcode.com/problems/median-of-two-sorted-arrays/solution/)
     
