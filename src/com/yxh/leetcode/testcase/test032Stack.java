package com.yxh.leetcode.testcase;

import java.util.Stack;

public class test032Stack {
	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int start = 0;
		int maxLen = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {   //前面都是右括号的情况   跳过
					// record the position before first left parenthesis
					start = i + 1;
				} else {
					stack.pop();  //弹出左括号
					// if stack is empty mean the positon before the valid left
					// parenthesis is "last"
					if (stack.isEmpty()) {
						maxLen = Math.max(i - start + 1, maxLen);
					} else {
						// if stack is not empty, then for current i the longest
						// valid parenthesis length is
						// i-stack.peek()
						maxLen = Math.max(i - stack.peek(), maxLen);
					}
				}
			}
		}
		return maxLen;
	}
}
