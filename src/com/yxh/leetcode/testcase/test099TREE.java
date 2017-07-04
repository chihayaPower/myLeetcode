package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * 题目：
 * 
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?



Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 

题解：

 解决方法是利用中序遍历找顺序不对的两个点，最后swap一下就好。

 因为这中间的错误是两个点进行了交换，所以就是大的跑前面来了，小的跑后面去了。

 所以在中序便利时，遇见的第一个顺序为抵减的两个node，大的那个肯定就是要被recovery的其中之一，要记录。

 另外一个，要遍历完整棵树，记录最后一个逆序的node。

 简单而言，第一个逆序点要记录，最后一个逆序点要记录，最后swap一下。

 因为Inorder用了递归来解决，所以为了能存储这两个逆序点，这里用了全局变量，用其他引用型遍历解决也可以。
 */
public class test099TREE {
    TreeNode pre;
    TreeNode first;
    TreeNode second;
      
    public void inorder(TreeNode root){  
        if(root == null)  
            return;  

        inorder(root.left);  
        if(pre == null){  
            pre = root;  //pre指针初始
        }else{  
            if(pre.val > root.val){  
                if(first == null){  
                    first = pre;//第一个逆序点    大的是第一个逆序点              1 f6 3 4 5 s2 7 8
                }  
                second = root;  //不断寻找最后一个逆序点     被大的是第二个逆序点
            }  
            pre = root;  //pre指针每次后移一位
        }  
        inorder(root.right);  
    }  
      
    public void recoverTree(TreeNode root) {  
        pre = null;  
        first = null;  
        second = null;  
        inorder(root);  
        if(first!=null && second!=null){   
            int tmp = first.val;  
            first.val = second.val;  
            second.val = tmp;  
        }  
    }
}
