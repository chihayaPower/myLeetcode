package com.yxh.leetcode.testcase;

import java.util.Arrays;
import java.util.Stack;

/*
 * LeetCode 笔记系列 17 Largest Rectangle in Histogram

题目： Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.



Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 



The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.

解法一： 这样的题目一般都有O(n)的解法，因为O(n2)的解法实在是太显而易见了。

可悲的是，本娃就只写出了后者。。。代码如下：

 View Code
基本思想就是遍历所有[i, j]，并在过程中找出中间最矮的bar，得出从i到j的矩形面积。

不过我就知道，一定有大神用他们极简的代码来切题，下面就是一个。
http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html

用stack算递增的面积
 */
public class test084 {
	public int largestRectangleArea2(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
