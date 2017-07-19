package com.yxh.leetcode.testcase;

import java.util.LinkedList;

import com.yxh.leetcode.testcase.entity.TreeNode;

public class test104TREE最大深度 {
	public int maxDepth(TreeNode root) {  
	    if(root == null)  
	        return 0;  
	    return Math.max(maxDepth(root.left),maxDepth(root.right))+1;  
	}  
	
	
	public int maxDepth2(TreeNode root) {   //BFS层次遍历 
	    if(root == null)  
	        return 0;  
	    int level = 0;  
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
	    queue.add(root);  
	    int curNum = 1; //num of nodes left in current level  
	    int nextNum = 0; //num of nodes in next level  
	    while(!queue.isEmpty())  
	    {  
	        TreeNode n = queue.poll();  
	        curNum--;  
	        if(n.left!=null)  
	        {  
	            queue.add(n.left);  
	            nextNum++;  
	        }  
	        if(n.right!=null)  
	        {  
	            queue.add(n.right);  
	            nextNum++;  
	        }  
	        if(curNum == 0)  
	        {  
	            curNum = nextNum;  
	            nextNum = 0;  
	            level++;  
	        }  
	    }  
	    return level;  
	}  
}
