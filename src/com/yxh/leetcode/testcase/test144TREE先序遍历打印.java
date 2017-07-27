package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;

import com.yxh.leetcode.testcase.entity.TreeNode;

public class test144TREE先序遍历打印 {
	public List<Integer> preorderTraversal(TreeNode root) {  
	    List<Integer> res = new ArrayList<Integer>();  
	    helper(root, res);  
	    return res;  
	}  
	private void helper(TreeNode root, List<Integer> res)  
	{  
	    if(root == null)  
	        return;  
	    res.add(root.val);  
	    helper(root.left,res);  
	    helper(root.right,res);  
	}  
}
