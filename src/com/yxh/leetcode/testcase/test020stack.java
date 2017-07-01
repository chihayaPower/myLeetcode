package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 20. Valid Parentheses

Total Accepted: 121935
Total Submissions: 401671
Difficulty: Easy
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
Subscribe to see which companies asked this question

来源： https://leetcode.com/problems/valid-parentheses/

题目要求如下：

Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid.


The brackets must close in the correct order, "()" and "()[]{}" are
 all valid but "(]" and "([)]" are
 not.

这一题是典型的使用压栈的方式解决的问题，题目中还有一种valid情况没有说明，需要我们自己考虑的，就是"({[]})"这种层层嵌套但
可以完全匹配的，也是valid的一种。解题思路是这样的：我们对字符串S中的每一个字符C，如果C不是右括号，就压入栈stack中。
如果C是右括号，判断stack是不是空的，空则说明没有左括号，直接返回not valid，非空就取出栈顶的字符pre来对比，如果是匹配
的，就弹出栈顶的字符，继续取S中的下一个字符；如果不匹配，说明不是valid的，直接返回。当我们遍历了一次字符串S后，注意
这里还有一种情况，就是stack中还有残留的字符没有得到匹配，即此时stack不是空的，这时说明S不是valid的，因为只要valid，一
定全都可以得到匹配使左括号弹出。

以下是我的代码，欢迎各位大牛指导交流~
 */
public class test020stack {
    public static boolean isValid(String s) {
        if (s == null || s.length()%2 != 0){
        	return false;
        }
        
        List<String> left= new ArrayList<>();
        List<String> right= new ArrayList<>();
        
        left.add("(");
        left.add("[");
        left.add("{");
        
        right.add(")");
        right.add("]");
        right.add("}");
    	
        Stack stack = new Stack();
        
        for(int i = 0; i < s.length(); i++) {
        	String cur = s.charAt(i)+"";
        	
        	if(left.contains(cur)) {
        		stack.push(cur);
        	} else if (right.contains(cur)) {
        		if (stack.isEmpty()) {
        			return false;
        		} else {
        			String leftChar = stack.pop().toString();
        			if (!left.contains(leftChar)) {
        				return false;
        			}
        			
        			int curIndex = right.indexOf(cur);
        			int leftIndex = left.indexOf(leftChar);
        			
        			if (curIndex != leftIndex) {
        				return false;
        			}
        		}
        		
        	} else {
        		return false;
        	}
        	
        }
        
        if (!stack.isEmpty()) {
    	
    	return false;
        } 
        
        return true;
    }
    
    
    public static void main(String[] args) {
    	String sample = "({[]}))";
    	boolean flag = isValid(sample);
    	if (flag) {
    		System.out.println("yes");
    	} else {
    		System.out.println("no");
    	}
    }
}
