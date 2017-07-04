package com.yxh.leetcode.testcase;

import java.util.ArrayList;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * 题目：

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
题解：

题目非常善良的给了binary search tree的定义。

这道题就是判断当前树是不是BST，所以递归求解就好。

 

第一种方法是中序遍历法。

因为如果是BST的话，中序遍历数一定是单调递增的，如果违反了这个规律，就返回false。

代码如下：
 */
public class test098TREEBST {
	public boolean isValidBST(TreeNode root) {  
	    ArrayList<Integer> pre = new ArrayList<Integer>();  
	    pre.add(null);  
	    return helper(root, pre);  
	}  
	private boolean helper(TreeNode root, ArrayList<Integer> pre)  
	{  
	    if(root == null)  
	        return true; 
	    
	    boolean left = helper(root.left,pre); 
	    
	    if(pre.get(pre.size()-1)!=null && root.val<=pre.get(pre.size()-1))  
	        return false;  
	    pre.add(root.val);  
	    
	    boolean right = helper(root.right,pre);
	    return left && right;  
	}
}
