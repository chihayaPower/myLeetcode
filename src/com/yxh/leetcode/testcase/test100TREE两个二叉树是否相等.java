package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * 题目：

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 

题解：

递归判断左右是否相等。

代码如下：
 */
public class test100TREE两个二叉树是否相等 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        
        if(p==null&&q!=null)
            return false;
        
        if(p!=null&&q==null)
            return false;
            
        if(p.val!=q.val)
            return false;
        boolean isleftsame = isSameTree(p.left,q.left);
        if(!isleftsame)
            return false;
            
        boolean isrightsame = isSameTree(p.right,q.right);
        if(!isrightsame)
            return false;
        
        return true;
        
    }
}
