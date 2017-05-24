package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;

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
