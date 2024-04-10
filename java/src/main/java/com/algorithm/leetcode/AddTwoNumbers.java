package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. <br>
     The digits are stored in reverse order and each of their nodes contain a single digit.<br>
     Add the two numbers and return it as a linked list.<br>
     You may assume the two numbers do not contain any leading zero, except the number 0 itself.<br>
     Example:<br>
     ,,,
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        ListNode temp2 = l2;
        List<Integer> rlist = new ArrayList<Integer>();
        while(temp!=null || temp2!=null){
            int v1 = temp==null?0:temp.val;
            int v2 = temp2==null?0:temp2.val;
            rlist.add(Integer.valueOf(v1+v2));
            System.out.println("v1+v2 = "+(v1+v2));
            if(temp==null || temp.next==null){
                temp = null;
            }else{
                temp = temp.next;
            }
            if(temp2==null || temp2.next==null){
                temp2 = null;
            }else{
                temp2 = temp2.next;
            }
        }

        if(rlist!=null && rlist.size()>0) {
            int[] rarr = new int[rlist.size()];
            for (int i = 0; i < rlist.size(); i++) {
                rarr[i] = rlist.get(i);
            }

            ListNode node = null;
            ListNode temp3 = null;
            int sum = 0;
            for (int i = 0; i < rarr.length; i++) {
                if (i == 0) {
                    node = new ListNode((rarr[i] % 10 + sum)%10);
                    sum = (rarr[i] + sum) / 10;
                    temp3 = node;
                } else {
                    temp3.next = new ListNode((rarr[i] % 10 + sum)%10);
                    sum = (rarr[i]  + sum) / 10;
                    temp3 = temp3.next;
                }
                if(i==rarr.length-1 && sum>0){
                    temp3.next = new ListNode(sum);
                }
            }
            return node;
        }
        return null;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        ListNode temp2 = l2;

        int v1 = l1!=null?l1.val:0;
        int v2 = l2!=null?l2.val:0;

        ListNode node = new ListNode((v1+v2)%10);
        ListNode temp3 = node;
        int carry = (v1+v2) / 10;;
        while(temp!=null || temp2!=null){
            v1 = 0;
            v2 = 0;
            if(temp!=null && temp.next!=null ){
                temp = temp.next;
                v1 = temp.val;
            }else{
                temp = null;
            }
            if(temp2!=null && temp2.next!=null){
                temp2 = temp2.next;
                v2 = temp2.val;
            }else{
                temp2 = null;
            }

            if(temp!=null || temp2!=null){
                temp3.next = new ListNode(((v1+v2) % 10 + carry)%10);
                temp3 = temp3.next;

                carry = ((v1+v2)  + carry) / 10;
            }

        }

        return node;
    }


    public ListNode initListNode(int[] arr){
        ListNode node = null;
        ListNode temp = null;
        if(arr!=null && arr.length>0){
            for(int i=0;i<arr.length;i++){
                if(i==0){
                    node = new ListNode(arr[i]);
                    temp = node;
                }else{
                    temp.next = new ListNode(arr[i]);
                    temp = temp.next;
                }
            }
        }
        return node;
    }
    public static void main(String[] args){
        AddTwoNumbers atn = new AddTwoNumbers();
        //81 + 0 = 1->8 + 0 = 1,8
        //3458 + 32 = 8->5->4->3 + 2->3 = 0943
        int[] a = {8,5,4,3};
        int[] b = {3,5};//77043  34077
        ListNode l1 = atn.initListNode(a);
        ListNode l2 = atn.initListNode(b);
        ListNode rs = atn.addTwoNumbers2(l1,l2);
        while(rs!=null){
            System.out.print(rs.val+",");
            rs = rs.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
    }
}
