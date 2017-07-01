package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.ListNode;

public class test024list {
	/*
	 * 24. Swap Nodes in Pairs


Given a linked list, swap every two adjacent nodes and return its head.

For example,

Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
Subscribe to see which companies asked this question

来源： https://leetcode.com/problems/swap-nodes-in-pairs/
	 */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next== null) return head;
        
        ListNode helper = new ListNode(0);
        ListNode ret = head;
        ListNode cur = helper;
        while(ret != null && ret.next != null)
        {
            ListNode next=ret.next.next;
            cur.next=ret.next;
            cur=cur.next;
            cur.next=ret;
            cur=cur.next;
            cur.next=null;
            ret=next;
        }
        if(ret!=null) cur.next=ret;
        return helper.next;
    }
    
    public static void main(String[] args) {
    	
    }
}
