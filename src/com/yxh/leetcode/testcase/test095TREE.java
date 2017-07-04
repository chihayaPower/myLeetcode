package com.yxh.leetcode.testcase;

import java.util.ArrayList;

import com.yxh.leetcode.testcase.entity.TreeNode;

/*
 * 题目： 

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


题解：
这道题比1难的就是不是返回个数，而是返回所有结果。
引用code ganker（http://codeganker.blogspot.com/2014/04/unique-binary-search-trees-ii-leetcode.html）的讲解：
”这道题是求解所有可行的二叉查找树，从Unique Binary Search Trees中我们已经知道，
可行的二叉查找树的数量是相应的卡特兰数，不是一个多项式时间的数量级，
所以我们要求解所有的树，自然是不能多项式时间内完成的了。算法上还是用求解NP问题的方法来求解，
也就是N-Queens中
介绍的在循环中调用递归函数求解子问题。思路是每次一次选取一个结点为根，然后递归求解左右子树的所有结果，
最后根据左右子树的返回的所有子树，依次选取
然后接上（每个左边的子树跟所有右边的子树匹配，而每个右边的子树也要跟所有的左边子树匹配，
总共有左右子树数量的乘积种情况），构造好之后作为当前树的结果返回。
“
这道题的解题依据依然是：
当数组为 1，2，3，4，.. i，.. n时，基于以下原则的BST建树具有唯一性：
以i为根节点的树，其左子树由[1, i-1]构成， 其右子树由[i+1, n]构成。 
代码如下：
 * 
 * 
 * 
 */
public class test095TREE {
	public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);//从1作为root开始，到n作为root结束
    }
     
    private ArrayList<TreeNode> generateTrees(int left, int right){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (left > right){
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++){
            ArrayList<TreeNode> lefts = generateTrees(left, i-1);//以i作为根节点，左子树由[1,i-1]构成
            ArrayList<TreeNode> rights = generateTrees(i+1, right);//右子树由[i+1, n]构成
            for (int j = 0; j < lefts.size(); j++){
                for (int k = 0; k < rights.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    res.add(root);//存储所有可能行
                }
            }
        }
        return res;
    }
}
