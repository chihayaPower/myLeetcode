package com.yxh.leetcode.testcase;

import java.util.HashMap;
import java.util.Map;

import com.yxh.leetcode.testcase.entity.ListNode;
import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * 　　这里的实现用Map保存了元素位置和元素值之间的映射，
 * 提升了查找元素的效率。但是整体的效率仍然一般，因为这里有一个从int到Integer元素的boxing和unboxing转换。
　　那么，除了上述的方法，还有没有其他的方法呢？
 
方法二
　　上面的那个办法也算是一个不错的思路了。不过这里还有一个办法更加巧妙。
因为对于一个排序后的链表来说，它就相当于是对二叉树的中序遍历得到的结果。
如果我们模拟一个二叉树中序遍历里递归调用回溯的过程，就可以一边遍历二叉树一边把对应的二叉树给建立起来。
　　比如说这里链表的第一个节点，它正好就对应二叉树的最左下角的元素。而它的下一个元素呢，
正好就对应着前面二叉树递归调用里要回溯到的那个节点。于是我们可以有如下的代码实现：

 */

public class test109有序链表转排序二叉树 {
	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
		private Map<Integer, ListNode> map = new HashMap<>();

		public TreeNode sortedListToBST(ListNode head) {
			if (head == null)
				return null;
			int count = 0;
			ListNode node = head;
			while (node != null) {
				map.put(count, node);
				count++;
				node = node.next;
			}
			return sortedListToBST(map, 0, count - 1);
		}

	
		private TreeNode sortedListToBST(Map<Integer, ListNode> map, int l, int r) {
			if (l > r)
				return null;
			int mid = l + (r - l) / 2;
			TreeNode node = new TreeNode(map.get(mid).val);
			node.left = sortedListToBST(map, l, mid - 1);
			node.right = sortedListToBST(map, mid + 1, r);
			return node;
		}
		
		
		/********************************
		 * solution 2
		 * @param map
		 * @param l
		 * @param r
		 * @return
		 */
		
		 private ListNode cur;  
		    public TreeNode sortedListToBST2(ListNode head) {  
		        cur = head;  
		        return generate(count(head));  
		    }  
		      
		    private TreeNode generate(int n) {  
		        if(n == 0) return null;  
		        TreeNode node = new TreeNode(0);  
		        node.left = generate(n / 2);  
		        node.val = cur.val;  
		        cur = cur.next;  
		        node.right = generate(n - n / 2 - 1);  
		        return node;  
		    }  
		      
		    private int count(ListNode node) {  
		        int count = 0;  
		        while(node != null) {  
		            count++;  
		            node = node.next;  
		        }  
		        return count;  
		    }  

}
