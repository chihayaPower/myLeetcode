package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;

/*
 * Palindrome Partitioning leetcode java
题目：

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]


题解：
这道题还是一种找组合的可能性，类似于wordbreakii。
这里想法是，用递归循环找子问题的方法，把母串按所有组合可能性拆分，如果是回文，就加进来，当层数为s的length时就有一个结果了。
这里需要判断是否为回文。
利用validPalindrome的思想很容易就写出来了（这里不需要判断大小写还有有没有别的字符）。
 */
public class test131子串回文DFS {
	public List<List<String>> partition(String s) {
        ArrayList<String> item = new ArrayList<String>();
        List<List<String>> res = new ArrayList<List<String>>();
        
        if(s==null||s.length()==0)
            return res;
        
        dfs(s,0,item,res);   //DFS
        return res;
    }
    
    public void dfs(String s, int start, ArrayList<String> item, List<List<String>> res){
        if (start == s.length()){
            res.add(new ArrayList<String>(item));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i+1);
            if (isPalindrome(str)) {
                item.add(str);
                dfs(s, i+1, item, res);
                item.remove(item.size() - 1); //恢复现场
            }
        }
    }
    
    
    public boolean isPalindrome(String s){
         int low = 0;
         int high = s.length()-1;
         while(low < high){
             if(s.charAt(low) != s.charAt(high))
                return false;
             low++;
             high--;
         }
         return true;
    }
}
