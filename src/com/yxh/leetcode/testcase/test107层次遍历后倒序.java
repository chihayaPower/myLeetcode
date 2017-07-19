package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * Binary Tree Level Order Traversal II leetcode java
题目：

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

题解：
这道题跟前面一道是一样的。。
只是存到res的结果顺序不一样罢了。
之前那个就是循序的存
这道题就是每得到一个行结果就存在res的0位置，这样自然就倒序了。

 */
public class test107层次遍历后倒序 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
        if(root == null)  
            return res;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);
        
        int curLevCnt = 1;  
        int nextLevCnt = 0;  
        
        ArrayList<Integer> levelres = new ArrayList<Integer>();  
       
        while(!queue.isEmpty()){  
            TreeNode cur = queue.poll();  
            curLevCnt--;  
            levelres.add(cur.val);  
            
            if(cur.left != null){  
                queue.add(cur.left);  
                nextLevCnt++;  
            }  
            if(cur.right != null){  
                queue.add(cur.right);  
                nextLevCnt++;  
            }  
              
            if(curLevCnt == 0){  
                curLevCnt = nextLevCnt;  
                nextLevCnt = 0;  
                res.add(0,levelres);  //insert one by one from the beginning
                levelres = new ArrayList<Integer>();  
            }  
        }  
        return res;  
    }
}
