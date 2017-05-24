package com.yxh.leetcode.testcase;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.yxh.leetcode.testcase.entity.ListNode;

public class test023 {
	public ListNode mergeKLists(ListNode[] lists) {
		
		if (lists.length<1) {
			return null;
		}
		
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		});
		for (int i = 0; i < lists.length; i++) {
			ListNode node = lists[i];
			if (node != null) {
				heap.offer(node);
			}
		}
		ListNode head = null;
		ListNode pre = head;
		while (heap.size() > 0) {
			ListNode cur = heap.poll();
			if (head == null) {
				head = cur;
				pre = head;
			} else {
				pre.next = cur;
			}
			pre = cur;
			if (cur.next != null)
				heap.offer(cur.next);
		}
		return head;
	}

	public static void main(String[] args) {

	}
}
