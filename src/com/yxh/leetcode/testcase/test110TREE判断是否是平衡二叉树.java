package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * 
 *  Balanced Binary Tree
 *  
 *  Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Seen this question in a real interview before?   Yes  


Balanced Binary Tree leetcode java
题目：

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 

题解：

 采用递归的方法，要记录depth用来比较。


 */
public class test110TREE判断是否是平衡二叉树 {
	public int checkBalanced(TreeNode t){
        if(t==null)
            return 0;
            
        int leftheight = checkBalanced(t.left);
        if(leftheight == -1)
            return -1;
        
        int rightheight = checkBalanced(t.right);
        if(rightheight == -1)
            return -1;
        
        if(Math.abs(leftheight-rightheight)>1)
            return -1;
        else
            return Math.max(leftheight,rightheight)+1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(checkBalanced(root) == -1)
            return false;
        else
            return true;
    }
}
