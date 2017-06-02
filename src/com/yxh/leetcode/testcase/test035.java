package com.yxh.leetcode.testcase;


/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

Subscribe to see which companies asked this question.
 */
public class test035 {
	   public int searchInsert(int[] A, int target) {

	        int mid;
	        int lo = 0;
	        int hi = A.length - 1;

	        while (lo <= hi) {
	            mid = lo + (hi - lo)/ 2;

	            if (A[mid] == target) {
	                return mid;
	            } else if (A[mid] < target){
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }

	        return lo;
	    }
}
