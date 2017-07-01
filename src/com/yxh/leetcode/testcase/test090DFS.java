package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 题目：

Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


题解：
这个在subset题的第一种解法的基础上有两种解决办法。。
1. 在添加res时候判断是否res中已经存过该item了。没存过的才存保证子集唯一性。
 代码如下：
 */
public class test090DFS {
	public static void dfs(int[] S, int start, int len, ArrayList<Integer> item,ArrayList<ArrayList<Integer>> res){
        if(item.size()==len){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=start; i<S.length;i++){
            item.add(S[i]);
            dfs(S, i+1, len, item, res);
            item.remove(item.size()-1);
            while(i<S.length-1&&S[i]==S[i+1])//跳过重复元素
                i++;
        }

    }
    
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> item = new ArrayList<Integer>();
        if(S.length==0||S==null)
            return res;
        
        Arrays.sort(S);
        for(int len = 1; len<= S.length; len++)
            dfs(S,0,len,item,res);
            
        res.add(new ArrayList<Integer>());
        
        return res;
    }
}
