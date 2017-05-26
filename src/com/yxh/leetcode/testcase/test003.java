package com.yxh.leetcode.testcase;

/*
 * 3. Longest Substring Without Repeating Characters

April 10, 2016
Question
Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

来源： https://leetcode.com/articles/longest-substring-without-repeating-characters/


Java (Assuming ASCII 128)
The previous implements all have no assumption on the charset of the string s.
If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.
Commonly used tables are:
int[26] for Letters 'a' - 'z' or 'A' - 'Z'
int[128] for ASCII

int[a] = index
 */




public class test003 {
    public static int lengthOfLongestSubstring(String s) {
		int length = s.length();
		
		int[] index = new int[128];
		
		int resLength = 0;
		
		for (int i = 0, j = 0; j < length; j++){
            i = Math.max(index[s.charAt(j)], i);  //上个重复的字母的index
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
