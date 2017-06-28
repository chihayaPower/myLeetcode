package com.yxh.leetcode.testcase;


/*
 * 题目：
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

题意：
给定一组分别具有红白蓝颜色的对象，重新排序他们使得相同颜色的对象相邻。排序后的顺序是红白蓝。
这里我们用 0, 1, and 2 来分别表示红白蓝三个颜色。
注意：不能用库中的排序函数。
算法分析：
方法一：
三指针的方法，类似于快速排序
left = 0，指针right = n-1；一次遍历，如果遇到0，交换给left，遇到2，交换给right，遇到1别管。
方法二：
下面是比较low的一种方法，但是比较好理解
分别统计0,1,2的个数，对数组重新进行赋值
 */
public class test075 {
    public void sortColors(int[] A) 
    {
        if (A == null || A.length == 0) return;
        int left = 0;
        int right = A.length - 1;
        int cur = left;
        
        while(cur <= right)
        {
        	if (A[cur] == 0) 
        	{
        		swap(A, left++, cur);
        		cur = (cur <= left) ? left : cur;
        	} 
        	else if (A[cur] == 2) 
        	{
        		swap(A, right--, cur);
        	} 
        	else 
        	{
        		cur++;
        	}
        }
    }
    public void swap(int[] A, int i, int j) 
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    public void sortColors2(int[] A) 
    {
        int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		for(int i = 0; i < A.length; i++)
		{
			if(A[i] == 0)
			{
				count0++;
			}
			if(A[i] == 1)
			{
				count1++;
			}
			if(A[i] == 2)
			{
				count2++;
			}
		}
		for(int i = 0; i < count0; i++)
		{
			A[i] = 0;
		}
		for(int i = count0; i < count0+count1; i++)
		{
			A[i] = 1;
		}
		for(int i = count0+count1; i < count0+count1+count2; i++)
		{
			A[i] = 2;
		}
    }
}
