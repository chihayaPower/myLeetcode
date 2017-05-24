package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class test020 {
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
