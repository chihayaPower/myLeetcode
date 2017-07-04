package com.yxh.leetcode.testcase;


/*
 * 96:Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

 

1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

查了下，这个题要用卡特兰数 参考了这个博客也没看明白：http://www.cnblogs.com/springfor/p/3884009.html
然后看了三哥的一个视频讲解：https://www.youtube.com/watch?v=UfA_v0VmiDg

所以抛开卡特兰数，大思想是动态规划。找出递推公式。
思路就是：反正就是BST，每个元素都做根节点，算出每个元素做根节点时有几种情况，然后每个节点的几种情况相加。
每个元素有几种情况，根据bst的特性，就是中序便利是排序的。所以：
以n＝3为例。新建一个int res[]= int[3+1](循环1，2，3，每个数字对应所再index，而不是1对应0index，2对应1 index...)
1是根节点的时候，1的左子树是0个，右子树是2，3（两个）。所以是1是根节点的种类数是：res[0]乘以res[2]情况数。
2是根节点的时候，2的左子树是1（1个），右子树是1（1个）。所以是2是根节点的种类数是：res[1]乘以res[1]情况数。
3是根节点的时候，3的左子树是1，2（2个），右子树是（0个）。所以是2是根节点的种类数是：res[2]乘以res[0]情况数。

 */
public class test096TREE卡特兰数 {
	    public int numTrees(int n) {
	        if(n ==0 || n ==1) return 1;
	        int res[] =new int[n+1];
	        res[0]=1;
	        for(int i =1 ; i <= n ; i++){
	            for(int j = 0; j < i; j++){
	                res[i] += res[j]*res[i-j-1];
	             }
	         }
	        return res[n];
	    }
}
