package com.yxh.leetcode.testcase;
/*
 * Valid Palindrome leetcode java
题目：

Given a string, determine if it is a palindrome, 
considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? 
This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

 

题解：

 这道题的几个点，
一就是alphanumeric characters and ignoring cases，字母和数字，忽略大小写。 
二就是考虑空字符串是否为回文，最好在面试时候问下面试官，这里是认为空字符串是回文。
因为忽略大小写，所以就统一为大写。
然后就判断当前检查字符是否符合范围，否则大小指针挪动。
如果发现有大小指针指向的值有不同的，就返回false，否则，继续检查。
最后返回true。
 */
public class test125回文 {
	public static boolean isPalindrome(String s) {
        if(s.length()==0)
            return true;
        
        s = s.toUpperCase();
        int alaphLow = 'A', alaphHigh = 'Z';
        int numLow = '0', numHigh = '9';
        int low = 0, high = s.length()-1;
        
        while(low < high){
            if((s.charAt(low)<alaphLow||s.charAt(low)>alaphHigh)
                && (s.charAt(low)<numLow||s.charAt(low)>numHigh)){
                    low++;
                    continue;
                }
                
            if((s.charAt(high)<alaphLow||s.charAt(high)>alaphHigh)
                && (s.charAt(high)<numLow||s.charAt(high)>numHigh)){
                    high--;
                    continue;
                }
            if(s.charAt(low) == s.charAt(high)){
                low++;
                high--;
            }else
                return false;
        }
        return true;
    }
}
