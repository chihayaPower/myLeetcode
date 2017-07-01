package com.yxh.leetcode.testcase;

public class test045IMPORT {
	/*
	 * 题意：

给定一个非负整数数组，给定的初始化位置在数组的起始位置。
数组中的每个元素代表着你能都在此位置跳跃的最大的距离。
你的目标是用最少的跳跃数达到数组的末尾。
比如：给定A = [2,3,1,1,4]
达到数组尾部的最小的跳跃步数为2。（用1步从索引 0 到 1， 接着用3步到达结尾索引。）

算法分析：
该题思想主要是，扫描数组，以确定当前最远能覆盖的节点，放入maxreach。然后继续扫描，直到当前的路程超过了上一次算出的覆盖范围reach，那么更新覆盖范围，同时更新条数，因为我们是经过了多一跳才能继续前进的。
形象地说，这个是在争取每跳最远的greedy.
	 * 
	 */
	/** 
	    * ret:目前为止的jump数 
	 
	    * curRch:从A[0]进行ret次jump之后达到的最大范围 
	 
	    * curMax:从0~i这i+1个A元素中能达到的最大范围 
	     
	    * 当curRch < i，说明ret次jump已经不足以覆盖当前第i个元素，因此需要增加一次jump，使之达到 
	 
	    * 记录的curMax。 
	     
	    */   
    public int jump(int[] nums)   
    {  
        int ret = 0;  
        int curMax = 0;  
        int curRch = 0;  
        for(int i = 0; i < nums.length; i ++)  
        {  
            if(curRch < i)  
            {  
                ret ++;  
                curRch = curMax;  
            }  
            curMax = Math.max(curMax, nums[i]+i);  
        }  
        return ret;  
    }   
}
