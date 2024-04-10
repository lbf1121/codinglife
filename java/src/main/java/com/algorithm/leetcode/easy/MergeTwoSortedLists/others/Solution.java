package com.algorithm.leetcode.easy.MergeTwoSortedLists.others;

import com.algorithm.leetcode.easy.MergeTwoSortedLists.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/discuss/301827/java-easy-to-understand-0ms-solution
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode current = fakeHead;
        while( l1 != null && l2 != null ) {
            if( l1.val <= l2.val ) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null )
            current.next = l1;
        else if( l2 != null )
            current.next = l2;
        return fakeHead.next;
    }
}
