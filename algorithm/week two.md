Add Two Numbers
---
You are given two non-empty linked lists representing two non-negative integers. <br>
The digits are stored in reverse order and each of their nodes contain a single digit.<br>
Add the two numbers and return it as a linked list.<br>
You may assume the two numbers do not contain any leading zero, except the number 0 itself.<br>
Example:<br>
```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```
方案1：將两个ListNode中的值依次求和，放入新的集合List中
```Java
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1.将两个ListNode中值一次求和
        ListNode temp = l1;
        ListNode temp2 = l2;
        List<Integer> rlist = new ArrayList<Integer>();
        while(temp!=null && temp2!=null){
            int v1 = temp.val;
            int v2 = temp2.val;
            rlist.add(Integer.valueOf(v1+v2));
            temp = temp.next;
            temp2 = temp2.next;
        }

        if(rlist!=null && rlist.size()>0) {
            int[] rarr = new int[rlist.size()];
            for (int i = 0; i < rlist.size(); i++) {
                rarr[(rlist.size() - 1) - i] = rlist.get(i);
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
            }
            return node;
        }
        return null;
    }
```