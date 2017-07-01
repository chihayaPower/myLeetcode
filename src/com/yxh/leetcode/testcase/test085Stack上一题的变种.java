package com.yxh.leetcode.testcase;

import java.util.Arrays;
import java.util.Stack;

/*
 * 题目：

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

 
 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

题解：

 这道题可以应用之前解过的Largetst Rectangle in Histogram一题辅助解决。解决方法是：

按照每一行计算列中有1的个数，作为高度，当遇见0时，这一列高度就为0。然后对每一行计算 Largetst Rectangle in Histogram，最后得到的就是结果。
 */
public class test085Stack上一题的变种 {
	public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] height = new int[n];//对每一列构造数组
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '0')//如果遇见0，这一列的高度就为0了
                    height[j] = 0;
                else
                    height[j] += 1;   //不等于0的连续的1个数
            }
            max = Math.max(largestRectangleArea(height),max);
        }
        return max;
    }
    
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i);
                i++;
            }else {
                int t = stack.pop();
                int square = -1;
                if(stack.isEmpty())
                    square = h[t]*i;
                else{
                    int x = i-stack.peek()-1;
                    square = h[t]*x;
                }
                maxArea = Math.max(maxArea, square);
            }
        }
        return maxArea;
    }
}
