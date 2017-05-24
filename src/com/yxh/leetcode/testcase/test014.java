package com.yxh.leetcode.testcase;

public class test014 {
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
