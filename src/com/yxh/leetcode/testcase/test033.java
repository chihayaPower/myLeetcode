package com.yxh.leetcode.testcase;

/*
 * 原题链接: http://oj.leetcode.com/problems/search-in-rotated-sorted-array/ 
这道题是二分查找Search Insert Position的变体，看似有点麻烦，其实理清一下还是比较简单的。因为rotate的缘故，当我们切取一半的时候可能会出现误区，所以我们要做进一步的判断。具体来说，假设数组是A，每次左边缘为l，右边缘为r，还有中间位置是m。在每次迭代中，分三种情况：
（1）如果target==A[m]，那么m就是我们要的结果，直接返回；
（2）如果A[m]<A[r]，那么说明从m到r一定是有序的（没有受到rotate的影响），那么我们只需要判断target是不是在m到r之间，如果是则把左边缘移到m+1，否则就target在另一半，即把右边缘移到m-1。
（3）如果A[m]>=A[r]，那么说明从l到m一定是有序的，同样只需要判断target是否在这个范围内，相应的移动边缘即可。
根据以上方法，每次我们都可以切掉一半的数据，所以算法的时间复杂度是O(logn)，空间复杂度是O(1)。代码如下：
 */
public class test033 {
	    public int search(int[] A, int target) {  
	        if (A == null || A.length == 0) return -1;  
	        int left = 0;  
	        int right = A.length - 1;  
	        while (left <= right) {  
	            int mid = left + (right - left) / 2;  
	            if (A[mid] == target) {  
	                return mid;  
	            }   
	            if (A[left] <= A[mid]) {  
	                if (A[left] <= target && target < A[mid]) {  
	                    right = mid - 1;  
	                } else {  
	                    left = mid + 1;  
	                }  
	            } else {  
	                if (A[mid] < target && target <= A[right]) {  
	                    left = mid + 1;  
	                } else {  
	                    right = mid - 1;  
	                }  
	            }  
	        }  
	        return -1;  
	    }  
}
