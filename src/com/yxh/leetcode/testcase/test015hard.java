package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test015hard {
	
	/*
	 * 15 这道题凭我现有知识实在解答不上来，只好网上搜索解法，才发现 K Sum 是一类问题，但是网上没有比较简洁的代码，我想对于初学者来说，可能还是想先看看这道题怎么解，然后才有兴趣去看其扩展吧。
【题目】
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
	 */
	
  	static List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static List<List<Integer>> threeSum(int[] nums) {
        
    	if (nums == null || nums.length < 3) {
    		return res;
    	}
    	
    	Arrays.sort(nums);
    	
    	int len = nums.length;
    	
    	for (int i = 0; i < len-2; i++) {   //针对每个元素， 寻找从其后一个元素开始到最后一个元素之间的两个数  总和为0
    		//if (i > 0 && nums[i] == nums[i-1]) continue;
    		find(nums, i+1, len-1, nums[i]);
    	}
    	
    	return res;
    	

    }	
    
	private static void find(int[] nums, int begin, int end, int target) {
		
		int L = begin; int R = end;
		
		
		while (L < R) {
			if (nums[L] + nums[R] + target == 0) {
				List<Integer> ans = new ArrayList<>();
				ans.add(nums[L]);
				ans.add(nums[R]);
				ans.add(target);
				res.add(ans);
				
				L++;
				R--;
				
			} else if (nums[L] + nums[R] + target < 0) {
				L++;
			} else if (nums[L] + nums[R] + target > 0) {
				R--;
			}
		}
	}	
	



	public static void main(String[] args) {
		int[] sample = {2,3,4,5,6,7,8,-1,0,1,-2,-3,-5,-7};
		
		
		List<List<Integer>> res = threeSum(sample);
		
		for(int i = 0; i < res.size(); i++) {
			List<Integer> innerList = res.get(i);
			for(int j = 0; j < innerList.size(); j++) {
				int a = innerList.get(j);
				System.out.println(a);
			}
			
		}
	}
}
