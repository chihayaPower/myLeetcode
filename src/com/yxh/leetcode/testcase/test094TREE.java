package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import com.yxh.leetcode.testcase.entity.TreeNode;

public class test094TREE {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    helper(root, res);
	    return res;
	}
	private void helper(TreeNode root, ArrayList<Integer> res)
	{
	    if(root == null)
	        return;
	    helper(root.left,res);
	    res.add(root.val);
	    helper(root.right,res);
	}
	
	/*
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	    while(root!=null || !stack.isEmpty())
	    {
	        if(root!=null)
	        {
	            stack.push(root);
	            root = root.left;
	        }
	        else
	        {
	            root = stack.pop();
	            res.add(root.val);
	            root = root.right;
	        }
	    }
	    return res;
	}*/
	
	/*
	 * 最后我们介绍一种比较复杂的方法，这个问题我有个朋友在去google onsite的时候被问到了，
	 * 就是如果用常量空间来中序遍历一颗二叉树。这种方法叫 Morris Traversal。想用O(1)空间进行遍历，
	 * 因为不能用栈作为辅助空间来保存付节点的信息，重点在于当访问到子节点的时候如何重新回到父节点（当然这里是指没有父节点指针，如果有其实就比较好办，一直找遍历的后驱结点即可）。
	 * Morris遍历方法用了线索二叉树，这个方法不需要为每个节点额外分配指针指向其前驱和后继结点，而是利用叶子节点中的右空指针指向中序遍历下的后继节点就可以了。
算法具体分情况如下：
1. 如果当前结点的左孩子为空，则输出当前结点并将其当前节点赋值为右孩子。
2. 如果当前节点的左孩子不为空，则寻找当前节点在中序遍历下的前驱节点（也就是当前结点左子树的最右孩子）。接下来分两种情况：
 a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点（做线索使得稍后可以重新返回父结点）。然后将当前节点更新为当前节点的左孩子。
 b) 如果前驱节点的右孩子为当前节点，表明左子树已经访问完，可以访问当前节点。将它的右孩子重新设为空（恢复树的结构）。输出当前节点。当前节点更新为当前节点的右孩子。 
代码如下：
	 */
	
	/*

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    TreeNode cur = root;
	    TreeNode pre = null;
	    while(cur != null)
	    {
	        if(cur.left == null)
	        {
	            res.add(cur.val);
	            cur = cur.right;
	        }
	        else
	        {
	            pre = cur.left;
	            while(pre.right!=null && pre.right!=cur)
	                pre = pre.right;
	            if(pre.right==null)
	            {
	                pre.right = cur;
	                cur = cur.left;
	            }
	            else
	            {
	                pre.right = null;
	                res.add(cur.val);
	                cur = cur.right;
	            }
	        }
	    }
	    return res;
	}
	*/
}
