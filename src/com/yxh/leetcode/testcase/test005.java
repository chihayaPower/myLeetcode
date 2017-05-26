package com.yxh.leetcode.testcase;


/*
 * 5. Longest Palindromic Substring

April 8, 2016
Question
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

来源： https://leetcode.com/articles/longest-palindromic-substring/
 */
public class test005 {
    public static String longestPalindrome(String s) {
    	int start = 0;
    	int end = 0;
    	
    	for (int i = 0; i < s.length(); i++) {
    		int len1 = findWhile(s, i, i );
    		int len2 = findWhile(s, i, i+1 );
    		
    		int len = Math.max(len1, len2);
    		
    		if (len > end - start) {
    			start = i - (len - 1)/2;
    			end = i + len/2;
    		}
    		
    	}
    	return s.substring(end, start);
    	
    }


	private static int findWhile(String s, int i, int j) {
		// TODO Auto-generated method stub
		int L = i; int R = j;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		
		return 0;
	}










	public static void main(String args) {
		
		String tmp = "babad";
		
		String aa = longestPalindrome(tmp);
		
		System.out.println(aa);
		
	}

}
