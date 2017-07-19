package com.yxh.leetcode.testcase;

import java.util.LinkedList;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * Minimum Depth of Binary Tree

题目：

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 

题解： 

递归解法急速判断左右两边子树哪个depth最小，要注意如果有个节点只有一边孩子时，不能返回0，要返回另外一半边的depth。 


 */
public class test111TREE最窄深度 {
	public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int minleft = minDepth(root.left);
        int minright = minDepth(root.right);
        if(minleft==0 || minright==0)
            return minleft>=minright?minleft+1:minright+1;
        return Math.min(minleft,minright)+1;
    }
	
	
	public int minDepth2(TreeNode root) {
        if(root == null)
            return 0;
        
        int depth = 1;//The minimum depth is the number of nodes along 
                      //the shortest path from the root node down to the 
                      //nearest leaf node.
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curnum = 1;
        int nextnum = 0;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            curnum--;
            
            if(cur.left == null && cur.right == null)   //最近的叶节点到了直接返回
                return depth;
            
            if(cur.left != null){
               queue.add(cur.left);
               nextnum++;
            }
            
            if(cur.right != null){
                queue.add(cur.right);
                nextnum++;
            }
            
            if(curnum == 0){
                curnum = nextnum;
                nextnum = 0;
                depth++;
            }
        }
        return depth;
    }
}
