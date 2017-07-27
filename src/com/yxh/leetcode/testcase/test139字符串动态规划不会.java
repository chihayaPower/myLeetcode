package com.yxh.leetcode.testcase;

import java.util.List;

/*
 * Word Break leetcode java
题目：

Given a string s and a dictionary of words dict, 
determine if s can be segmented into a space-separated 
sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

 

题解：

这道题的题解转载自Code ganker，他写的很好。地址：
http://blog.csdn.net/linhuanmars/article/details/22358863

“原题链接: http://oj.leetcode.com/problems/word-break/ 
这道题仍然是动态规划的题目，我们总结一下动态规划题目的基本思路。首先我们要决定要存储什么历史信息以及用什么数据结构来存储信息。
然后是最重要的递推式，就是如从存储的历史信息中得到当前步的结果。最后我们需要考虑的就是起始条件的值。
接 下来我们套用上面的思路来解这道题。首先我们要存储的历史信息res[i]是表示到字符串s的第i个元素为止能不能用字典中的词来表示，
我们需要一个长度 为n的布尔数组来存储信息。然后假设我们现在拥有res[0,...,i-1]的结果，
我们来获得res[i]的表达式。思路是对于每个以i为结尾的子 串，看看他是不是在字典里面以及他之前的元素对应的res[j]是不是true，
如果都成立，那么res[i]为true，写成式子是



假 设总共有n个字符串，并且字典是用HashSet来维护，那么总共需要n次迭代，每次迭代需要一个取子串的O(i)操作，
然后检测i个子串，而检测是 constant操作。所以总的时间复杂度是O(n^2)（i的累加仍然是n^2量级），而空间复杂度则是字符串的数量，
即O(n)。代码如下：
 */
public class test139字符串动态规划不会 {
	public boolean wordBreak(String s, List<String> dict) {
	    if(s==null || s.length()==0)
	        return true;
	    boolean[] res = new boolean[s.length()+1];
	    res[0] = true;
	    for(int i=0;i<s.length();i++)   //挨个遍历字符串 
	    {
	        StringBuilder str = new StringBuilder(s.substring(0,i+1));   //到该字符的子串
	        for(int j=0;j<=i;j++)   //遍历这个子串
	        {
	            if(res[j] && dict.contains(str.toString()))  //模板串包含这个子串   且   到当前子串index为止能用字典串表示
	            {
	                res[i+1] = true;  //到外面循环的index为止是可以用字典表示的
	                break; //退出循环
	            }
	            str.deleteCharAt(0);   //从前面删掉一个字符
	        }
	    }
	    return res[s.length()];
	}
}
