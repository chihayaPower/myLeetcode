package com.yxh.leetcode.testcase;

public class test026 {
	public int removeDuplicates(int[] A) {
	    if(A.length ==0){
	      return 0;
	    }
	    int count=1;
	    for(int i=1; i<A.length; ++i){
	      if(A[count-1] != A[i]){ //注意这行代码   （count-1 == i-1）     
	        A[count]=A[i];
	        count++;
	      }
	    }
	    return count;
	  }
}
