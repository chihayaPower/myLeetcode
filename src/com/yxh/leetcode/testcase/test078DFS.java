package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.Arrays;


/*
 * Given a set of distinct integers, S, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
给出一个数组生成该数组所有元素的组合。
基本思路循环+dfs，生成指定元素数目（0，1,2,...array.size()个元素）的组合。
1和2的区别在于2中允许数组中出现重复的元素。所以2在dfs的时候要跳过重复的元素，例如：[1,1,2]  如果不加跳过处理的话，生成的子集会有两个：[1,2]，但[1,1,2]是一个合理的组合。
LeetCode Subsets的AC代码：
 */

public class test078DFS {
	 void dfs(int [] number_array, int start, int number, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> result) {
	        if(number==array.size()) {
	            result.add(new ArrayList<Integer>(array));
	            return;
	        }
	        for(int i=start;i<number_array.length;i++) {
	            array.add(number_array[i]);
	            dfs(number_array,i+1,number,array,result);
	            array.remove(array.size()-1);
	        }
	    }
	    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	          ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	          ArrayList<Integer> array = new ArrayList<Integer>();
	          result.add(array);
	          if(S==null) {
	              return result;
	          }
	          Arrays.sort(S);  //为何要排序？
	          for(int i=1;i<=S.length;i++) {   //其实和上一题一样     不过上一题有个固定个数    这题没有固定次数
	              array.clear();
	              dfs(S,0,i,array,result);
	          }
	          return result;
	    }
}
