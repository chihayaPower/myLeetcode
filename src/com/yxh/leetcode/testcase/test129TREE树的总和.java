package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * Sum Root to Leaf Numbers leetcode java
题目：

Given a binary tree containing digits from 0-9 only, 

each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 

which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

 

题解：

 分析这道题，由根节点往叶节点方向走，就是从高位往地位加和的方向。
 也就是说，当遍历的节点往叶节点方向走一层的时候，该节点的值应为父节点的值*10+当前节点的值。

由此可以写出代码：
 */
public class test129TREE树的总和 {
	int sumhelper(TreeNode root, int levelBase) {
        if(root == null)
            return 0;
            
        if(root.left == null && root.right == null) {
            return levelBase + root.val; 
        }
        
        int nextLevelBase = (levelBase + root.val)*10 ;
        int leftSubTreeSum = sumhelper(root.left, nextLevelBase);
        int rightSubTreeSum = sumhelper(root.right, nextLevelBase);
    
        return leftSubTreeSum + rightSubTreeSum;
    }
    
    public int sumNumbers(TreeNode root) {
        return sumhelper(root,0);
    }
}
