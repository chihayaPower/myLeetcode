package com.yxh.leetcode.testcase;

/*
 * 原题链接: http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/ 
这道题跟Remove Duplicates from Sorted Array比较类似，区别只是这里元素可以重复出现至多两次，而不是一次。其实也比较简单，
只需要维护一个counter，当counter是2时，就直接跳过即可，否则说明元素出现次数没有超，继续放入结果数组，
若遇到新元素则重置counter。总体算法只需要扫描一次数组，所以时间上是O(n)，空间上只需要维护一个index和counter，
所以是O(1)。代码如下：
 */
public class test080 {
	public int removeDuplicates(int[] A) {
	    if(A==null || A.length==0)
	        return 0;
	    int idx = 0;
	    int count = 0;
	    for(int i=0;i<A.length;i++)
	    {
	        if(i>0 && A[i]==A[i-1])
	        {
	            count++;
	            if(count>=3)
	                continue;
	        }
	        else
	        {
	            count = 1;
	        }
	        A[idx++]=A[i];
	    }
	    return idx;
	}
}
