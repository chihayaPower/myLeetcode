package com.yxh.leetcode.testcase;


/*
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

Analysis:

桶排序，每次当A[i]!= i的时候，将A[i]与A[A[i]]交换，直到无法交换位置。终止条件是 A[i]== A[A[i]]。
然后i -> 0 到n走一遍就好了。
 */
public class test041 {
	public int firstMissingPositive(int[] A) {  
        for(int i=0;i<A.length;i++){  
            while(A[i]!=i+1){  
                if(A[i]<=0 ||A[i]>=A.length|| A[i]==A[A[i]-1]) break;  
                int temp = A[i];  
                A[i] = A[A[i]-1];  
                A[temp-1] = temp;  
            }  
              
        }  
        for(int i=0;i<A.length;i++){  
            if(A[i]!=i+1)  
                return i+1;  
        }  
        return A.length+1;  
    }  
}
