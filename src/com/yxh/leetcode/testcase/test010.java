package com.yxh.leetcode.testcase;

public class test010 {
    public static boolean isMatch(String s, String p) {
        return true;
    }
    
    
    public static void main(String[] args){
        String target = "abcdefg";
        String regex = ".*";
        
        boolean flag = isMatch(target, regex);
        
        
        if (flag) {
        	System.out.println("yes");
        } else {
        	System.out.println("no");
        }
             
             
    	
    	
    	
    }
}
