package com.yxh.leetcode.testcase;

import java.util.HashSet;

/*
 * Longest Consecutive Sequence leetcode java
题目：

Given an unsorted array of integers, 
find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

 

题解：

这道题利用HashSet的唯一性解决，能使时间复杂度达到O(n)。
首先先把所有num值放入HashSet，然后遍历整个数组，如果HashSet中存在该值，
就先向下找到边界，找的同时把找到的值一个一个从set中删去，然后再向上找边界，
同样要把找到的值都从set中删掉。所以每个元素最多会被遍历两边，时间复杂度为O(n)。
 */
public class test128最长的连续串 {
	public int longestConsecutive(int[] num) {  
        if(num == null||num.length == 0)
            return 0;
        
        HashSet<Integer> hs = new HashSet<Integer>();  
        
        for (int i = 0 ;i<num.length; i++)     //去重
            hs.add(num[i]);  
         
        int max = 0;  
        for(int i=0; i<num.length; i++){  
            if(hs.contains(num[i])){
                int count = 1;  
                hs.remove(num[i]);
                
                int low = num[i] - 1; 
                while(hs.contains(low)){  //向下找下界
                    hs.remove(low);  
                    low--;  
                    count++;  
                }
                
                int high = num[i] + 1;  
                while(hs.contains(high)){  //向上找上界
                    hs.remove(high);  
                    high++;  
                    count++;  
                }  
                max = Math.max(max, count);  
            }  
        }  
        return max;  
    }
}
