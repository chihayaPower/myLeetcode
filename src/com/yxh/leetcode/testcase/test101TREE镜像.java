package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3


题目大意

　　给定一棵树，判断它是否是对称的。即树的左子树是否是其右子树的镜像。 

解题思路

　　使用递归进行求解，先判断左右子结点是否相等，不等就返回false，
相等就将左子结点的左子树与右子结果的右子结点进行比较操作，
同时将左子结点的左子树与右子结点的左子树进行比较，只有两个同时为真是才返回true，否则返回false。 
 */

public class test101TREE镜像 {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            return isSame(root.left, root.right);
        }
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }  if (left != null && right == null || left == null && right != null){
            return false;
        } else {
            return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
        }
    }
}

