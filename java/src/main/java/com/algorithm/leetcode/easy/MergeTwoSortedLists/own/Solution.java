package com.algorithm.leetcode.easy.MergeTwoSortedLists.own;

import com.algorithm.leetcode.easy.MergeTwoSortedLists.ListNode;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

     ListNode first = null;
     ListNode last = null;

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
            return l1==null?l2:l1;
        }


        while(l1!=null || l2!=null){
            if(l1==null && l2!=null){

                add(l2.val);
                l2 = l2.next;
            }else if(l1!=null && l2==null){

                add(l1.val);
                l1 = l1.next;
            }else{
                if(l1.val<=l2.val){

                    add(l1.val);
                    l1 = l1.next;
                }else{
                    add(l2.val);

                    l2 = l2.next;
                }
            }

        }

        return first;
    }

    void add(int val){
        ListNode oldListNode = last;
        last = new ListNode(val);
        last.next = null;
        if   (first==null) first = last;
        else oldListNode.next = last;
    }

    static ListNode initListNode(int[] n){
        //sort
        Arrays.sort(n);

        //init
        ListNode first = null;
        ListNode last = null;
        if(n!=null && n.length>0){
            for (int i = 0; i < n.length ; i++) {
                ListNode oldListNode = last;
                last = new ListNode(n[i]);
                last.next = null;
                if   (first==null) first = last;
                else oldListNode.next = last;
            }
        }
        return first;
    }


    public static void main(String[] args) {
        int[] n1 = {1,2,3};
        int[] n2 = {1,3,4};

        Solution s = new Solution();
        ListNode listNode = s.mergeTwoLists(initListNode(n1),initListNode(n2));

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        };
    }
}
