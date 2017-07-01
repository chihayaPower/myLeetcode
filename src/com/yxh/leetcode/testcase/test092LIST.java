package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.ListNode;

/*
 * Reverse Linked List II
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ? m ? n ? length of list.

题解：

 经典的题目就是链表逆序啦，一般的链表逆序是让把链表从前到后都逆序，这个是给定了起始位置和结束位置，方法是一样的。

 就是维护3个指针，startpoint，node1和node2。

 startpoint永远指向需要开始reverse的点的前一个位置。

 node1指向正序中第一个需要rever的node，node2指向正序中第二个需要reverse的node。 

 交换后，node1 在后，node2在前。这样整个链表就逆序好了。
 * 
 */
public class test092LIST {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        
        if(head==null||head.next==null)
            return newhead.next;
            
        ListNode startpoint = newhead;//startpoint指向需要开始reverse的前一个
        ListNode node1 = null;//需要reverse到后面去的节点
        ListNode node2 = null;//需要reverse到前面去的节点
        
        for (int i = 0; i < n; i++) {
            if (i < m-1){
                startpoint = startpoint.next;//找真正的startpoint
            } else if (i == m-1) {//开始第一轮
                node1 = startpoint.next;
                node2 = node1.next;
            }else {
                node1.next = node2.next;//node1交换到node2的后面
                node2.next = startpoint.next;//node2交换到最开始
                startpoint.next = node2;//node2作为新的点
                node2 = node1.next;//node2回归到node1的下一个，继续遍历
            }
        }
        return newhead.next;
    }
}
