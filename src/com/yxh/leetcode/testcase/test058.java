package com.yxh.leetcode.testcase;

public class test058 {
	/*
	 * Length of Last Word
	 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
	 */
    public int lengthOfLastWord(String s) {  
        if(s.trim().equals("")|| s.length() == 0){  
            return 0;  
        }  
      
        String[] ss = s.trim().split(" ");  
        int len = ss.length;  
        return ss[len - 1].length();  
          
    } 
}
