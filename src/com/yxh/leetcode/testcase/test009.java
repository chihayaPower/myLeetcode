package com.yxh.leetcode.testcase;

public class test009 {
	
	/*
	 * 09 [LeetCode] Palindrome Number
Determine whether an integer is a palindrome. Do this without extra space.
Some hints:
Could negative integers be palindromes? (ie, -1)
If you are thinking of converting the integer to string, note the restriction of using extra space.
You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
There is a more generic way of solving this problem.
	 */
	
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
