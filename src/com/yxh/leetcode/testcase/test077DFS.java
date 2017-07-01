package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;


/*
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class test077DFS {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n <= 0||n < k)
            return res;
        List<Integer> item = new ArrayList<Integer>();    
        dfs(n,k,1,item, res);//because it need to begin from 1
        return res;
    }
    private void dfs(int n, int k, int start, List<Integer> item, List<List<Integer>> res){
        if(item.size()==k){
            res.add(new ArrayList<Integer>(item));//because item is ArrayList<T> so it will not disappear from stack to stack
            return;
        }
        for(int i=start;i<=n;i++){
            item.add(i);
            dfs(n,k,i+1,item,res);
            item.remove(item.size()-1);  //恢复现场
        }
    }
}
