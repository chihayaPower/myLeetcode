package com.yxh.leetcode.testcase;

public class test003 {
    public static int lengthOfLongestSubstring(String s) {
		int length = s.length();
		
		int[] index = new int[128];
		
		int resLength = 0;
		
		for (int i = 0, j = 0; j < length; j++){
            i = Math.max(index[s.charAt(j)], i);
            resLength = Math.max(resLength, j - i + 1);
            index[s.charAt(j)] = j + 1;
		}
		
		return resLength;
    }
	
	
	
	
	public static void main(String[] args){
		String tmp = "abcabcbb";
		

		int res = lengthOfLongestSubstring(tmp);
		
		
		System.out.println(res);
		
	}
}
