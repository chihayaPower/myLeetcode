package com.yxh.leetcode.testcase;

import java.awt.image.SampleModel;

/*
 * 题目：

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

 

题解：

参考：低调小一（http://blog.csdn.net/wzy_1988/article/details/17752809）的解题思路

“首先，碰到这样的题目不要慌张，挨个分析每个A[i]能trapped water的容量，然后将所有的A[i]的trapped water容量相加即可

其次，对于每个A[i]能trapped water的容量，取决于A[i]左右两边的高度（可延展）较小值与A[i]的差值，即volume[i] = [min(left[i], right[i]) - A[i]] * 1，这里的1是宽度，如果the width of each bar is 2,那就要乘以2了”
 

那么如何求A[i]的左右高度呢？ 要知道，能盛多少水主要看短板。那么对每个A[i]来说，要求一个最高的左短板，再求一个最高的右短板，这两个直接最短的板子减去A[i]原有的值就是能成多少水了。

 

所以需要两遍遍历，一个从左到右，找最高的左短板；一个从右到左，找最高的右短板。最后记录下盛水量的总值就是最终结果了。
 */

public class test042 {
    public static int trap(int[] height) {
        if (height.length < 3) {
        	return 0;
        }
        
        int ret = 0;
        
        for (int i = 1; i< height.length-1; i++) {
        	int leftMax = findMax(height, 0, i-1);
        	int rightMax = findMax(height, i+1, height.length-1);
        	int volume = (Math.min(leftMax, rightMax) - height[i]) * 1;
        	System.out.println("volume = " +volume);
        	if (volume > 0) {
        		ret = ret + volume;
        	}
        }
        
        return ret;
    }
    
    private static int findMax(int[] height, int start, int end) {
		// TODO Auto-generated method stub
    	if (start == end) {
    		return height[start];
    	}
    	
    	int max = Integer.MIN_VALUE;
    	
    	for (int i = start; i <= end; i++) {
    		if(height[i] > max) {
    			max = height[i];
    		}
    	}
		return max;
	}

	public static void main(String[] args) {
    	int sample[] = {0,1,0,2,1,0,1,3,2,1,2,1};
    	
    	int res = trap(sample);
    	
    	System.out.println(res);
    }
}
