package com.yxh.leetcode.testcase;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.yxh.leetcode.testcase.entity.ListNode;

public class test023 {
	/*
	 * 23. Merge k Sorted Lists

题目：
  
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
  
题意：
  
将k个已排好序的链表合并为一个非下降排序的链表。
  
思路：
  
   
 
将每个链表的表头元素取出来，建立一个小顶堆，因为k个链表中都排好序了，因此每次取堆顶的元素就是k个链表中的最小值，可以将其合并到合并链表中，再将
这个元素的指针指向的下一个元素也加入到堆中，再调整堆，取出堆顶，合并链表。。。。以此类推，直到堆为空时，链表合并完毕。
  
    因为想练习建堆的过程，所以我没有用STL里的make_heap等方法，而是自己写的建堆函数。若想看用STL的建堆方法的，可以参考网上答案。
  
    建堆的时间复杂度是k/2logk, 每次取出堆顶再加入元素的复杂度是logk,假设每条链表平均有n个元素，则一共有nk-k次。因此总的时间复杂度为O(nklogk)。
  
    还有一种思路是取出两条，用merge2Lists的方法合并为一条，再将这条和下一条用merge2Lists来合并为一条，以此类推。假设每条链表平均有n个元素，此种时间复杂度是O(2n+3n+…+kn), 为O(nk²),因此若用此法会超时。
  
我的代码如下：
  
	 */
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
			ListNode cur = heap.poll();  //取堆顶的元素
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
