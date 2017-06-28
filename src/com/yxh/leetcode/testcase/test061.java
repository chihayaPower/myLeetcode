package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.ListNode;
/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

 

题解：

这道题主要先理解题意，就是倒着数k个node，从那开始到结尾和之前那部分对调，那个例子就是，4->5拿前面来，1->2->3拿后面去。

几个特殊：

k是可以大于整个list的长度的，所以这时要对k对len取模

如果取模之后得0，相当于不用rotate，直接返回

 

处理完特殊情况后，就用熟悉的faster/slower双指针解决就好（看到这种linkedlist，倒着数数的，就条件反射了）

先对faster设步长为n，然后faster和slower再一起走，知道faster.next==null，说明slower指向要倒着数的开始点的前一个位置。

所以slow.next就是要返回的newhead，保存一下。

然后把faster.next接到head上，slower.next存为null，作队尾。

这样就把list给rotate了。

这是我想的一种解法，还有一种就是把整个list连起来，变成环，找到切分点断开就行。
 */


public class test061 {
	public ListNode rotateRight(ListNode head, int n) {
        if(head==null||head.next==null||n==0)
            return head;
        ListNode fast = head, slow = head,countlen = head;
        ListNode newhead = new ListNode(-1);
        int len = 0;
        
        while(countlen!=null){
            len++;
            countlen = countlen.next;
        }
        
        n = n%len;
        if(n==0)
            return head;
        
        for(int i = 0; i < n; i++)
            fast = fast.next;
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        newhead = slow.next;
        fast.next = head;
        slow.next = null;
        
        return newhead;
    }
}
