package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.ListNode;

public class test021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null) {
    		return l2;
    	}
    	
    	if (l2 == null) {
    		return l1;
    	}
    	
    	ListNode p = l1;
    	ListNode q = l2;
    	ListNode head = null;
    	ListNode curNode = null;
    	
    	while(p!=null && q!=null) {
    		if (head == null) {
    			if (p.val < q.val) {
    				head = curNode = p;
    				p = p.next;
    				curNode.next = null;
    			} else {
    				head = curNode = q;
    				q = q.next;
    				curNode.next = null;
    			}
    		} else {
    			if (p.val < q.val) {
    				curNode.next = p;
    				curNode = p;
    				p = p.next;
    				curNode.next = null;
    			} else {
    				curNode.next = q;
    				curNode = q;
    				q = q.next;
    				curNode.next = null;
    			}
    		}
    	}
    	
    	if (p!=null) {
    		curNode.next = p;
    	} else if (q != null) {
    		curNode.next = q;
    	}
    	
    	return head;
        
    }
    
    
    public static void main(String[] args) {
    	
    	
    	
    }
}
