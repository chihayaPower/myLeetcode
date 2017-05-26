package com.yxh.leetcode.testcase;

public class test014 {
	/*
	 * 14 题目要求如下：
Write a function to find the longest common prefix string amongst an array of strings.
找出所有字符串的最长公共前缀。这道题很简单，但需要注意减少比较字符的操作次数。
思路是这样的：
2个字符串的最长公共前缀，其长度肯定不会超过最短的字符串的长度，设最短的字符串长度为n，那么只要比较这2个字符串的前n个字符即可。
如此得出这2个字符串的最长公共前缀prefix后，再拿prefix作为新的字符串和数组中的下一个字符串比较，方法同上。
需要注意的是，如果数组中的某个字符串长度为0，或者求得的当前最长公共前缀的长度为0，就直接返回空字串。
代码比较简单，就不注释了。欢迎指导交流~
AC，Runtime: 36 ms
	 */
    public String longestCommonPrefix(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as  
        // the same Solution instance will be reused for each test case.  
          
        if (strs.length == 0)  
          return "";  
          
        String prefix = strs[0];  
        for (int i = 1; i < strs.length; ++i)  
        {  
            if (prefix.length() == 0 || strs[i].length() == 0)  
               return "";  
              
            int len = prefix.length() < strs[i].length() ? prefix.length() : strs[i].length();  
              
            int j;  
              
            for (j = 0; j < len; ++j)  
            {  
                if (prefix.charAt(j) != strs[i].charAt(j))  
                    break;  
            }  
  
            prefix = prefix.substring(0,j);  
              
        }  
          
        return prefix;  
    }
	
	public static void main(String[] args) {
		
	}
}
