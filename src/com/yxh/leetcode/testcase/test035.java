package com.yxh.leetcode.testcase;

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
