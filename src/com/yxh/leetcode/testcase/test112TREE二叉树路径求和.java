package com.yxh.leetcode.testcase;

import java.util.LinkedList;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * 题目：

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 

题解： 

还是对树的操作，递归的解法：


 */
public class test112TREE二叉树路径求和 {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) 
            return false;
        
        sum -= root.val;
        if(root.left == null && root.right==null)  
            return sum == 0;
        else 
            return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }
	
	
	public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) return false;
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();
 
        nodes.add(root);
        values.add(root.val);
 
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();
 
            if(curr.left == null && curr.right == null && sumValue==sum){
                return true;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue+curr.left.val);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue+curr.right.val);
            }
        }
 
        return false;
    }
}
