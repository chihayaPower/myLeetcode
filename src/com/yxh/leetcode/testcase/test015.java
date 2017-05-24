package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test015 {
	
  	static List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static List<List<Integer>> threeSum(int[] nums) {
        
    	if (nums == null || nums.length < 3) {
    		return res;
    	}
    	
    	Arrays.sort(nums);
    	
    	int len = nums.length;
    	
    	for (int i = 0; i < len-2; i++) {
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
