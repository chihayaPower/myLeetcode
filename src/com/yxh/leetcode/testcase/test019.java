package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.ListNode;

/*
 * 19. Remove Nth Node From End of List

Question
Given a linked list, remove the nth node from the end of list and return its head.

For example,
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Try to do this in one pass.

来源： https://leetcode.com/articles/remove-nth-node-end-list/
 */

public class test019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;
        
        for (int i = 0; i < n + 1; i++) {
        	first = first.next;
        }
        
        while (first != null) {
        	first = first.next;
        	second = second.next;
        }
        
        second.next = second.next.next;
        return dummy.next;
    }
}
