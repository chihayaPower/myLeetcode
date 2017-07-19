package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * Path Sum II leetcode java
题目：

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

题解： 
这道题除了要判断是否有这样的一个path sum，还需要把所有的都可能性结果都返回，所以就用传统的DFS递归解决子问题。代码如下：

 */
public class test113TREE二叉树打印路径为某个和DFS {
	public void pathSumHelper(TreeNode root, int sum, List <Integer> sumlist, List<List<Integer>> pathlist){
        if(root==null) 
            return;
        sumlist.add(root.val);
        sum = sum-root.val;
        if(root.left==null && root.right==null){
            if(sum==0){
                pathlist.add(new ArrayList<Integer>(sumlist));
            }
        }else{
            if(root.left!=null)
                pathSumHelper(root.left,sum,sumlist,pathlist);
            if(root.right!=null)
                pathSumHelper(root.right,sum,sumlist,pathlist);
        }
        sumlist.remove(sumlist.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathlist=new ArrayList<List<Integer>>();
        List<Integer> sumlist = new ArrayList<Integer>();
        pathSumHelper(root,sum,sumlist,pathlist);
        return pathlist;
    }
}
