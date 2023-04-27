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
思路：將两个ListNode中的值依次求和，放入新的集合List中,将List转化为数组，重新计算ListNode。
```Java
class AddTwoNumbers{
    //第一版
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = l1;
            ListNode temp2 = l2;
            List<Integer> rlist = new ArrayList<Integer>();
            while(temp!=null || temp2!=null){
                int v1 = temp==null?0:temp.val;
                int v2 = temp2==null?0:temp2.val;
                rlist.add(Integer.valueOf(v1+v2));
               
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
                int carry = 0;
                for (int i = 0; i < rarr.length; i++) {
                    if (i == 0) {
                        node = new ListNode((rarr[i] % 10 + carry)%10);
                        carry = (rarr[i] + carry) / 10;
                        temp3 = node;
                    } else {
                        temp3.next = new ListNode((rarr[i] % 10 + carry)%10);
                        carry = (rarr[i]  + carry) / 10;
                        temp3 = temp3.next;
                    }
                    if(i==rarr.length-1 && carry>0){
                        temp3.next = new ListNode(carry);
                    }
                }
                return node;
            }
            return null;
    }

    //调整版：
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
}    
```
LeetCode 解题思路方法：初等数学<br>
   我们使用变量来跟踪进位，并从包含最低有效位的表头开始模拟逐位相加的过程。 <br>     
   ![image1](https://leetcode-cn.com/articles/Figures/2/2_add_two_numbers.svg)
   图1，对两数相加方法的可视化: 342 + 465 = 807342+465=807，每个节点都包含一个数字，并且数字按位逆序存储。

算法<br>
   
   就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表 l1 和 l2 的表头开始相加。<br>
   由于每位数字都应当处于 0…9 的范围内，我们计算两个数字的和时可能会出现“溢出”。<br>
   例如，5 + 7 = 125+7=12。在这种情况下，我们会将当前位的数值设置为 22，并将进位 carry=1 带入下一次迭代。<br>
   进位 carry必定是 0或 1，这是因为两个数字相加（考虑到进位）可能出现的最大和为 9 + 9 + 1 = 19<br>。
   
   伪代码如下：<br>
   
   将当前节点初始化为返回列表的哑节点。<br>
   将进位 carry 初始化为 0。<br>
   将 p 和 q 分别初始化为列表 l1 和 l2 的头部。<br>
   遍历列表 l1和 l2直至到达它们的尾端。<br>
   将 x 设为节点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。<br>
   将 y 设为节点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。<br>
   设定 sum = x + y + carry。<br>
   更新进位的值，carry = sum / 10。<br>
   创建一个数值为 (sum mod 10)的新节点，并将其设置为当前节点的下一个节点，然后将当前节点前进到下一个节点。<br>
   同时，将 p 和 q 前进到下一个节点。<br>
   检查 carry = 1是否成立，如果成立，则向返回列表追加一个含有数字 1 的新节点。<br>
   返回哑节点的下一个节点。<br>
   请注意，我们使用哑节点来简化代码。如果没有哑节点，则必须编写额外的条件语句来初始化表头的值。<br>
   
   请特别注意以下情况：<br>
    测试用例	说明<br>
    ```
        l1=[0,1]l1=[0,1] 
        l2=[0,1,2]l2=[0,1,2]	当一个列表比另一个列表长时。
        l1=[]l1=[] 
        l2=[0,1]l2=[0,1]	当一个列表为空时，即出现空列表。
        l1=[9,9]l1=[9,9] 
        l2=[1]l2=[1]	求和运算最后可能出现额外的进位，这一点很容易被遗忘
    ```
```Java
class AddTwoNumbers{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        //计算最后一个节点
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
```