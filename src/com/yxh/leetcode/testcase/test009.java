package com.yxh.leetcode.testcase;

public class test009 {
	
    public static boolean isPalindrome(int x) {
    	if (x < 0) {
    		return false;
    	} else if (x == 0) {
    		return true;
    	}
    	
        int base = (x+"").length();
        base = (int)Math.pow(10, base-1);
    	while (x > 0) {
    		int leftValue = x/base;
    		int rightValue = x%10;
    		
    		System.out.println(leftValue);
    		System.out.println(rightValue);
    		
    		if (leftValue != rightValue) {
    			return false;
    		}
    		
    		x = x - base*leftValue;
    		x = x / 10;
    		
    		base = base/100;
    		
    	}
        
        
    	
    	return true;
    }
    
    
    public static void main(String[] args) {
    	int a = 1;
    	
    	boolean flag = isPalindrome(a);
    	
    	if (flag) {
    		System.out.println("yes");
    	} else {
    		System.out.println("no");
    	}
    }

}
