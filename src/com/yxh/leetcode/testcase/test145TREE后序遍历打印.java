package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;

import com.yxh.leetcode.testcase.entity.TreeNode;

public class test145TREE后序遍历打印 {
	public void helper(TreeNode root, List<Integer> re){
        if(root==null)
            return;
        
        helper(root.left,re);
        helper(root.right,re);
        re.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> re = new ArrayList<Integer>();
        if(root==null)
            return re;
        helper(root,re);
        return re;
    }
}
