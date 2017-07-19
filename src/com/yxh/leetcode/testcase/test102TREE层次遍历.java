package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]


层次遍历二叉树，就是首先访问二叉树的第一层元素，再访问第二层，接着访问第三层，
以此类推。实现的方式是，用一个先进先出的队列作为辅助数据结构，用levelList保存每一层的元素，
用resultList保存所有的levelList，然后 
（1）把根节点入队列，并把一个哨兵节点入队列，哨兵节点用于标识某一层已经结束  
（2）当队列中元素个数大于1时（除哨兵节点外还有其它元素），进入循环。访问该元素，如果该元素为哨兵节点，则说明这一层已经结束了，并将一个哨兵节点入队，用于标识下一层结束的地方，把levelList存入resultList，并建一个新的levelList保存下一层的元素；否则，把该节点的值放进levelList，并把它不为null的孩子节点入队。 
（3）把levelList加入resultList。因为最后一个哨兵节点没有办法被访问到，导致保存最后一层元素的levelList没办法在循环中被添加进resultList。



 */
public class test102TREE层次遍历 {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root == null) {
            return resultList;
        }

        List<Integer> levelStorage = new LinkedList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  //队列
        queue.offer(root);
        queue.offer(null);   //哨兵节点   用于标识本层是否结束了
        while (queue.size() > 1) {
            TreeNode top = queue.poll();
            if (top == null) {   //哨兵节点  说明前面没有东西了   直接放入结果集   并在尾部再放一个哨兵节点
                resultList.add(levelStorage);
                queue.offer(null);
                levelStorage = new LinkedList<Integer>();
            } else {   //否则加入子节点
                levelStorage.add(top.val);
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
        }
        resultList.add(levelStorage);

        return resultList;
    }
	
	
	
	public List<List<Integer>> levelOrder2(TreeNode root) {
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    if (root == null)
	        return list;
	    
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    
	    
	    while (queue.size() != 0) {
	        List<Integer> alist = new ArrayList<Integer>();
	        
	        for (TreeNode child : queue)
	            alist.add(child.val);
	        
	        list.add(new ArrayList<Integer>(alist));
	        LinkedList<TreeNode> queue2=queue;
	        queue=new LinkedList<TreeNode>();
	        for(TreeNode child:queue2){
	            if (child.left != null)
	                queue.add(child.left);
	            if (child.right != null)
	                queue.add(child.right);
	        }
	    }
	    return list;

	}
	


}
