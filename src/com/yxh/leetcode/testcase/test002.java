package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.ListNode;

public class test002 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode r1) {
    	ListNode p = l1;
    	ListNode q = r1;
    	ListNode res = new ListNode(0);
    	
    	ListNode cur = res;
    	int adder = 0;
    	
    	while (p != null || q != null) {
    		int x = (p != null) ? p.val : 0;
    		int y = (q != null) ? q.val : 0;
    		
    		int add = x + y + adder;
    		if (add >= 10){
    			adder = 1;
    			add = add % 10;
    		} else {
    			adder = 0;
    		}
    		
    		cur.next = new ListNode(add);
    		cur = cur.next;
    		
    		if (p != null) p = p.next;
    		if (q != null) q = q.next;
    		
    	}
    	
    	if (adder > 0){
    		cur.next = new ListNode(adder);
    	}
    	
    	
    	
    	return res.next;
    }
	
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		
		l1.next = l2;		
		l2.next = l3;		
		l3.next = null;
		
		ListNode r1 = new ListNode(5);
		ListNode r2 = new ListNode(6);
		ListNode r3 = new ListNode(4);
		
		r1.next = r2;
		r2.next = r3;
		r3.next = null;
		
		ListNode res = addTwoNumbers(l1,r1);
		
		/*
		while(l1!=null) {
			System.out.println(l1.val);
			l1 = l1.next;
		}
		
		while(r1!=null) {
			System.out.println(r1.val);
			r1 = r1.next;
		}*/
		
		while(res!=null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
