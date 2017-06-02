package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;


/*
 * 22. Generate Parentheses


Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
题目：http://oj.leetcode.com/problems/generate-parentheses/
描述：给定一个非负整数n，生成n对括号的所有合法排列。
解答：
该问题解的个数就是卡特兰数，但是现在不是求个数，而是要将所有合法的括号排列打印出来。
       
该问题和《编程之美》的买票找零问题一样，通过买票找零问题我们可以知道，针对一个长度为2n的合法排列，第1到2n个位置都满足如下规则：左括号的个数
大于等于右括号的个数。所以，我们就可以按照这个规则去打印括号：假设在位置k我们还剩余left个左括号和right个右括号，如果
left>0，则我们可以直接打印左括号，而不违背规则。能否打印右括号，我们还必须验证left和right的值是否满足规则，如果
left>=right，则我们不能打印右括号，因为打印会违背合法排列的规则，否则可以打印右括号。如果left和right均为零，则说明我们
已经完成一个合法排列，可以将其打印出来。通过深搜，我们可以很快地解决问题，针对n=2，问题的解空间如下：
 */
public class test022 {
    public static List<String> generateParenthesis(int n) {
    	List<String> ret = new ArrayList<String>();
    	if (n < 1) {
    		return ret;
    	}
    	
    	generate(n,n,"",ret);
    	
        return ret;
    }
    
    
    static void generate(int leftNum,int rightNum,String s,List<String> result)  
    {  
        if(leftNum==0&&rightNum==0)  
        {  
        	result.add(s); 
        }  
        if(leftNum > 0)  
        {  
            generate(leftNum-1,rightNum,s+'(',result);  
        }  
        if(rightNum>0&&leftNum<rightNum)  
        {  
            generate(leftNum,rightNum-1,s+')',result);  
        }  
    }  
    
    public static void main(String[] args) {
    	
    	List<String> ret =generateParenthesis(3);
    	
    	for (int i = 0; i<ret.size(); i++) {
    		System.out.println(ret.get(i));
    	}
    	
    }
}
