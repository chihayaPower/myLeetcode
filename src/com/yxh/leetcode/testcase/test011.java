package com.yxh.leetcode.testcase;

public class test011 {
    public static int maxArea(int[] height) {
    	if (height.length < 2){
    		return 0;
    	}
    	
    	int ans = 0;
    	
    	int L = 0;
    	int R = height.length - 1;
    	
    	while (L < R) {
    		int value = (R - L)*Math.min(height[L], height[R]);
    		
    		if (value > ans) {
    			ans = value;
    		}
    		
    		if (height[L] < height[R]) {
    			L++;
    		} else {
    			R--;
    		}
    	}
    	
    	return ans;
        
    }
    
    
    public static void main(String[] args) {
    	int[] sample = {1,2,3,4,5,6,7,8,9};
    	
    	int res = maxArea(sample);
    	
    	System.out.println(res);
    }
}
