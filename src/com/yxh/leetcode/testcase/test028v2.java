package com.yxh.leetcode.testcase;

import java.util.Arrays;

public class test028v2 {
	public int strStr(String haystack, String needle) {
	    int sLen = haystack.length();  
	    int pLen = needle.length();  
	  
	    int i = 0;  
	    int j = 0;  
	    while (i < sLen && j < pLen)  
	    {  
	        if (haystack.charAt(i) == needle.charAt(j))  
	        {  
	            //①如果当前字符匹配成功（即S[i] == P[j]），则i++，j++      
	            i++;  
	            j++;  
	        }  
	        else  
	        {  
	            //②如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0      
	            i = i - j + 1;  
	            j = 0;  
	        }  
	    }  
	    //匹配成功，返回模式串p在文本串s中的位置，否则返回-1  
	    if (j == pLen)  
	        return i - j;  
	    else  
	        return -1; 
	}
}
