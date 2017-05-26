package com.yxh.leetcode.testcase;

import java.util.HashMap;
import java.util.Map;

/*
 * 1. Two Sum

March 5, 2016
Question
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution.
Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.

来源： https://leetcode.com/articles/two-sum/

Approach #3 (One-pass Hash Table) [Accepted]

It turns out we can do it in one-pass. While we iterate and inserting elements into the table, we also look back to check if current element's complement already exists in the table. If it exists, we have found a solution and return immediately.
 */


public class test001 {
	
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		int minus = target - nums[i];
    		
    		if (index.containsKey(minus)) {
    			return new int[]{index.get(minus), i};
    		}
    		
    		index.put(nums[i], i);
    		
    	}
    	
    	throw new IllegalArgumentException("No two sum solution");
    	
    }
	
	
    public static void main(String[] args) {
		
		
		int[] tmp = {2,7,15,23,45,56};
		
		
		int[] result = twoSum(tmp, 60);
		
		for (int i = 0; i < result.length; i++)
		System.out.println(result[i]);
		
	}

}
