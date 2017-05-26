package com.yxh.leetcode.testcase;

public class test011 {
	
	/*
	 * 11【题目】
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

【解析】
题意：在二维坐标系中，(i, ai) 表示 从 (i, 0) 到 (i, ai) 的一条线段，任意两条这样的线段和 x 轴组成一个木桶，找出能够盛水最多的木桶，返回其容积。
两层 for 循环的暴力法会超时，所以尽早放弃这种懒惰的想法。
有没有 O(n) 的解法？
答案是有，用两个指针从两端开始向中间靠拢，如果左端线段短于右端，那么左端右移，反之右端左移，知道左右两端移到中间重合，记录这个过程中每一次组成木桶的容积，返回其中最大的。（想想这样为何合理？）
	 */
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
