package com.yxh.leetcode.testcase;

import java.util.HashMap;
import java.util.Map;

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
