package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.ListNode;

public class test024 {
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
